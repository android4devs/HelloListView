package pl.froger.hellolistview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView lvLanguages;
	private String[] languages;
	private String[] helloPhrases;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lvLanguages = (ListView) findViewById(R.id.lvLanguages);
		initResources();
		initLanguagesListView();
	}

	private void initResources() {
		Resources res = getResources();
		languages = res.getStringArray(R.array.languages);
		helloPhrases = res.getStringArray(R.array.hello_phrases);
	}

	private void initLanguagesListView() {
		LanguagesArrayAdapter adapter = new LanguagesArrayAdapter(this, languages);
		lvLanguages.setAdapter(adapter);

		lvLanguages.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int pos,	long id) {
				Toast.makeText(getApplicationContext(), 
						helloPhrases[pos],
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}