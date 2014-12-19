package net.mobctrl.catchexception;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/**
 * 
 * @author Zheng Haibo
 * @web http://www.mobctrl.net
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Object object = null;
		Thread.setDefaultUncaughtExceptionHandler(new UnCatchExceptionHandler(
				this));
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// app will carsh after 2s,as the object is null
				object.hashCode();
			}
		}, 2000);
	}

}
