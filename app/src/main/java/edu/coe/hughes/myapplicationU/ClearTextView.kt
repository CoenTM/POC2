package edu.coe.hughes.myapplicationU

import android.content.Context
import android.text.Editable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ClearTextView:LinearLayout, View.OnClickListener {
    private var mText:EditText? = null
    private var mClearButton: Button? = null
    private var startVal:String? = null

    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ClearTextView)
        startVal = ta.getString(R.styleable.ClearTextView_startVal)
        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ClearTextView)
        startVal = ta.getString(R.styleable.ClearTextView_startVal)
        // mValue.setText(((Integer)startVal).toString());
        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mText = findViewById<EditText>(R.id.txtValue)
        mClearButton = findViewById<Button>(R.id.clearButton)
    }

    var value: Editable?
        get() = mText!!.text
        set(v) {
            mText!!.setText("")
        }

    override fun onClick(v: View) {
        mText!!.setText("")
    }
}