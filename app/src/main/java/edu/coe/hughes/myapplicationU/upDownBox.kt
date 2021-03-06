package edu.coe.hughes.myapplicationU

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class UpDownBox : LinearLayout, View.OnClickListener {
    private var mDownButton: Button? = null
    private var mUpButton: Button? = null
    private var mValue: TextView? = null
    private var startVal = 0

    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ClearTextView)
        startVal = ta.getInt(R.styleable.ClearTextView_startVal, 0)
        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ClearTextView)
        startVal = ta.getInt(R.styleable.ClearTextView_startVal, 0)
        // mValue.setText(((Integer)startVal).toString());
        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mDownButton = findViewById<View>(R.id.downButton) as Button
        mUpButton = findViewById<View>(R.id.upButton) as Button
        mValue = findViewById<View>(R.id.txtValue) as TextView
        mValue!!.text = startVal.toString()
        mDownButton!!.setOnClickListener(this)
        mUpButton!!.setOnClickListener(this)
    }

    var value: Int
        get() = mValue!!.text.toString().toInt()
        set(v) {
            mValue!!.text = v.toString()
        }

    override fun onClick(v: View) {
        var `val` = mValue!!.text.toString().toInt()
        when (v.id) {
            R.id.downButton -> `val`--
            R.id.upButton -> `val`++
        }
        mValue!!.text = `val`.toString()
    }
}