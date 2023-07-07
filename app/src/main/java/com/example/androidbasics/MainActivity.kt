package com.example.androidbasics



import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llTop.setOnDragListener(dragListener)
        llBottom.setOnDragListener(dragListener)

        dragableView.setOnLongClickListener {
            val clipText = "View moved clipData"
            val clipItem = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val clipData = ClipData(clipText, mimeTypes, clipItem)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(clipData,  dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }



    }

    private val dragListener = View.OnDragListener { view, dragEvent ->
        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                dragEvent.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                Toast.makeText(this@MainActivity, "A View chegou ao layout destinatário", Toast.LENGTH_SHORT).show()
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED ->{
                view.invalidate()
                Toast.makeText(this@MainActivity, "A View saiu do layout remetente", Toast.LENGTH_SHORT).show()
            }
            DragEvent.ACTION_DROP ->{
                val clipItem = dragEvent.clipData.getItemAt(0)
                val draggedData = clipItem.text
                Toast.makeText(this, draggedData, Toast.LENGTH_SHORT).show()
                view.invalidate()

                val draggedView = dragEvent.localState as View
                val draggedViewSender = draggedView.parent as LinearLayout
                draggedViewSender.removeView(draggedView)
                val draggedViewDestination = view as LinearLayout
                draggedViewDestination.addView(draggedView)

                draggedView.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> view.invalidate()
            else -> false
        }
        true
    }

}
