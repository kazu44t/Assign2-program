package io.kazuyoshi.weatherappjapan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class KantoActivity extends AppCompatActivity {

    private TextView location;
    private LinearLayout forecastsLayout;
    private ProgressBar progress;

    public class ApiTask extends GetWeatherForecastTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(WeatherForecast data) {
            super.onPostExecute(data);

            progress.setVisibility(View.GONE);

            if (data != null) {
                location.setText(data.location.area + " "
                        + data.location.prefecture + " "
                        + data.location.city);

                for (WeatherForecast.Forecast forecast : data.forecastList) {
                    View row = View.inflate(KantoActivity.this, R.layout.forecast_row, null);

                    TextView date = (TextView) row.findViewById(R.id.tv_date);
                    date.setText(forecast.dateLabel);

                    TextView telop = (TextView) row.findViewById(R.id.tv_telop);
                    telop.setText(forecast.telop);

                    TextView temperature = (TextView) row.findViewById(R.id.tv_temperature);
                    temperature.setText(forecast.temperature.toString());

                    ImageView image = (ImageView) row.findViewById(R.id.iv_weather);

                    // 画像の読み込み処理
                    ImageLoaderTask task = new ImageLoaderTask();
                    task.execute(new ImageLoaderTask.Request(image, forecast.image.url));

                    forecastsLayout.addView(row);
                }
            } else if (exception != null) {
                Toast.makeText(getApplicationContext(), exception.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanto);

        location = (TextView) findViewById(R.id.tv_location);
        forecastsLayout = (LinearLayout) findViewById(R.id.ll_forecasts);
        progress = (ProgressBar) findViewById(R.id.progress);

        new ApiTask().execute("130010");
    }
}