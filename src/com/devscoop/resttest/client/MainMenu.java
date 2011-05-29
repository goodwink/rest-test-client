package com.devscoop.resttest.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.codegist.crest.CRest;
import org.codegist.crest.CRestBuilder;

import com.devscoop.resttest.client.models.Account;
import com.devscoop.resttest.client.services.AccountService;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textDump = (TextView) this.findViewById(R.id.textDump);
        
        new AccountsTask(textDump).execute();
    }
    
    private static class AccountsTask extends AsyncTask<Void, Void, Account[]> {
    	TextView v = null;
    	
    	AccountsTask(TextView v) {
    		this.v = v;
    	}
    	
		@Override
		protected Account[] doInBackground(Void... params) {
			Map<String,String> props = new HashMap<String,String>();
			props.put("crest.config.url.add-slashes", "false");

			CRest crest = new CRestBuilder()
			                        .overrideDefaultConfigWith(props)
			                        .build();
			
			AccountService as = crest.build(AccountService.class);
			return as.getAccounts();
		}
		
		@Override
		protected void onPostExecute(Account[] result) {
			v.setText(Arrays.toString(result));
		}
    }
}