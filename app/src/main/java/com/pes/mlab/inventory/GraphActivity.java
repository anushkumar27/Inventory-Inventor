package com.pes.mlab.inventory;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;


public class GraphActivity extends ActionBarActivity {

    TextView profitview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        profitview = (TextView) findViewById(R.id.profitview);
        profitview.setText("Rs." + MainActivity.total);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        //graph.setHorizontalScrollBarEnabled(false);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"});
        //staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        //Viewport view = graph.getViewport();
        //view.setScrollable(true);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, MainActivity.profit[1]),
                new DataPoint(2, MainActivity.profit[2]),
                new DataPoint(3, MainActivity.profit[3]),
                new DataPoint(4, MainActivity.profit[4]),
                new DataPoint(5, MainActivity.profit[5]),
                new DataPoint(6, MainActivity.profit[6]),
                new DataPoint(7, MainActivity.profit[7]),
                new DataPoint(8, MainActivity.profit[8]),
                new DataPoint(9, MainActivity.profit[9]),
                new DataPoint(10, MainActivity.profit[10]),
                new DataPoint(11, MainActivity.profit[11]),
                new DataPoint(12, MainActivity.profit[12]),
                new DataPoint(13, MainActivity.profit[13]),
                new DataPoint(14, MainActivity.profit[14]),
                new DataPoint(15, MainActivity.profit[15]),
                new DataPoint(16, MainActivity.profit[16]),
                new DataPoint(17, MainActivity.profit[17]),
                new DataPoint(18, MainActivity.profit[18]),
                new DataPoint(19, MainActivity.profit[19]),
                new DataPoint(20, MainActivity.profit[20])

        });
        graph.addSeries(series);

        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series.setDrawValuesOnTop(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graph, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}
