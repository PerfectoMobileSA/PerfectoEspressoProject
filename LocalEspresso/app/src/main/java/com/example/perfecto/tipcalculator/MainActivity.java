//package com.example.perfecto.tipcalculator;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

package com.example.perfecto.tipcalculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText totalBillAmount;
    private SeekBar tipPercentSeekBar;
    private SeekBar tipsNumberOfPeople;
    private TextView totalAmountToBePaid;
    private TextView totalAmountOfTipsToBePaid;
    private TextView tipsPerPerson;
    private Button calculateTips;
    private EditText tipPercentInput;
    private int tipPercentValue = 0;
    private int tipsForNumberOfPeople = 0;
    private TextView tipPercentLabel;
    private TextView splitNumberLabel;
    private EditText tipsNumberOfPeopleInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalBillAmount = (EditText)findViewById(R.id.bill_value);
        tipPercentSeekBar = (SeekBar)findViewById(R.id.tip_percent_seekBar);
        tipPercentInput = (EditText)findViewById(R.id.tip_percent_input);
        tipsNumberOfPeople = (SeekBar)findViewById(R.id.split_number_seekBar);
        tipsNumberOfPeopleInput = (EditText)findViewById(R.id.split_number_input);
        totalAmountToBePaid = (TextView)findViewById(R.id.total_to_pay_result);
        totalAmountOfTipsToBePaid = (TextView)findViewById(R.id.total_tip_result);
        tipsPerPerson = (TextView)findViewById(R.id.tip_per_person_result);
        tipPercentLabel = (TextView)findViewById(R.id.tip_percent);
        splitNumberLabel = (TextView)findViewById(R.id.split_number);

        tipPercentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentValue = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipPercentLabel.setText("Tip Percent - " + seekBar.getProgress());
            }
        });
        tipsNumberOfPeople.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipsForNumberOfPeople = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                splitNumberLabel.setText("Split Number - " + seekBar.getProgress());
            }
        });

        tipsNumberOfPeopleInput.addTextChangedListener(new android.text.TextWatcher() {

            @Override
            public void afterTextChanged(android.text.Editable s) {
                tipsForNumberOfPeople = Integer.parseInt(s.toString());
                tipsNumberOfPeople.setProgress(tipsForNumberOfPeople);
                splitNumberLabel.setText("Split Number - " + tipsForNumberOfPeople);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        tipPercentInput.addTextChangedListener(new android.text.TextWatcher() {

            @Override
            public void afterTextChanged(android.text.Editable s) {
                tipPercentValue = Integer.parseInt(s.toString());
                tipPercentSeekBar.setProgress(tipPercentValue);
                tipPercentLabel.setText("Tip Percent - " + tipPercentValue);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        calculateTips = (Button) findViewById(R.id.calculate_tips);
        calculateTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalBillAmount.getText().toString().equals("") || totalBillAmount.getText().toString().isEmpty()) {
                    Toast.makeText(v.getContext(), "All Input field must be filled", Toast.LENGTH_LONG).show();
                    return;
                }
                double totalBillInput = Double.parseDouble(totalBillAmount.getText().toString());
                if (tipPercentValue == 0 || tipsForNumberOfPeople == 0) {
                    Toast.makeText(v.getContext(), "Set values for Tip percent and split number", Toast.LENGTH_LONG).show();
                    return;
                }
                double percentageOfTip = (totalBillInput * tipPercentValue) / 100;
                double totalAmountForTheBill = totalBillInput + percentageOfTip;
                double tipPerEachPerson = percentageOfTip / tipsForNumberOfPeople;
                totalAmountToBePaid.setText(removeTrailingZero(String.valueOf(String.format("%.2f", totalAmountForTheBill))));
                totalAmountOfTipsToBePaid.setText(removeTrailingZero(String.valueOf(String.format("%.2f", percentageOfTip))));
                tipsPerPerson.setText(removeTrailingZero(String.valueOf(String.format("%.2f", tipPerEachPerson))));
            }
        });
    }
    public String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(".")) {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if (newValue.startsWith(".0")) {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }
}
