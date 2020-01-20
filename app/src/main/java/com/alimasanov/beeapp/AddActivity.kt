package com.alimasanov.beeapp

import android.app.DatePickerDialog
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.alimasanov.beeapp.db.DBHelper
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val dbHelper = DBHelper(this)
        val db:SQLiteDatabase = dbHelper.writableDatabase

        var edt_date: EditText = findViewById(R.id.edt_date)
        val edt_note: EditText = findViewById(R.id.edt_note)
        val rg: RadioGroup = findViewById(R.id.rg)
        val btn_save: Button = findViewById(R.id.btn_save)
        val btn_cancel: Button = findViewById(R.id.btn_cancel)

        //datePickerDialog
        edt_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, year, month_of_year, day_of_month ->
                edt_date.setText("$day_of_month.$month_of_year.$year")
            }, year, month, day)

            dpd.show()
        }

        btn_save.setOnClickListener{
            val cv = ContentValues()

            //get radioButton index
            val radioButtonID = rg.checkedRadioButtonId
            val radioButton: View = rg.findViewById(radioButtonID)
            val index = rg.indexOfChild(radioButton)

            if(edt_date.text == null)
                Toast.makeText(this, "Заполните дату", Toast.LENGTH_SHORT).show()
            else {
                //add rows to database
                cv.put(DBHelper.COL_DATE, edt_date.text.toString())
                cv.put(DBHelper.COL_NOTE, edt_note.text.toString())
                rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, CheckedId ->
                    cv.put(DBHelper.COL_LARVAL_AGE, CheckedId)
                })
            }
        }
    }
}