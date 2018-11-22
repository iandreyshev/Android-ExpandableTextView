package at.blogc.android.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import at.blogc.android.viewModel.ExpandLinkActivityViewModel
import at.blogc.android.views.ExpandableTextView
import at.blogc.android.views.R
import kotlinx.android.synthetic.main.activity_expand_link.*

class ExpandLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expand_link)

        val viewModel = ViewModelProviders.of(this)[ExpandLinkActivityViewModel::class.java]

        tvExpandableText.setAnimationDuration(0)
        if (viewModel.isExpand) {
            tvExpandableText.collapse()
        } else {
            tvExpandableText.expand()
        }
        if (tvExpandableText.isExpanded) {
            tvExpandLink.visibility = View.GONE
        } else {
            tvExpandLink.visibility = View.VISIBLE
        }
        tvExpandableText.setAnimationDuration(500)

        tvExpandableText.setOnClickListener {
            if (!tvExpandableText.toggle()) {
                return@setOnClickListener
            }

            viewModel.isExpand = tvExpandableText.isExpanded

            if (tvExpandableText.isExpanded) {
                tvExpandLink.visibility = View.GONE
            } else {
                tvExpandLink.visibility = View.VISIBLE
            }
        }

        tvExpandableText.addOnExpandListener(object : ExpandableTextView.OnExpandListener {
            override fun onExpand(view: ExpandableTextView) {
            }
            override fun onCollapse(view: ExpandableTextView) {
            }
        })
    }

}
