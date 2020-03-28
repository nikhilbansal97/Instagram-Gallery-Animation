package app.nikhil.instagramgalleryanimation.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import app.nikhil.instagramgalleryanimation.R
import app.nikhil.instagramgalleryanimation.utils.Image
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_instagram_view.view.instagramView_imageView

class InstagramView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

  interface InstagramViewListener {
    fun onAnimationStart(imageUrl: String?)
    fun onAnimationStop()
  }

  private var listener: InstagramViewListener? = null
  private var srcImage: Image? = null
  private var imageDrawable: Drawable? = null

  fun setInstagramViewListener(viewListener: InstagramViewListener) {
    this.listener = viewListener
  }

  init {
    View.inflate(context, R.layout.layout_instagram_view, this)
    imageDrawable = ContextCompat.getDrawable(context, R.drawable.demorris)
  }

  fun setImageSrc(image: Image) {
    this.srcImage = image
    invalidate()
  }

  override fun dispatchDraw(canvas: Canvas?) {
    super.dispatchDraw(canvas)
    srcImage?.let { image ->
      Glide.with(context)
        .load(image.shortUrl)
        .centerCrop()
        .into(this.instagramView_imageView)
    }
  }

  override fun onInterceptTouchEvent(ev: MotionEvent): Boolean = true

  override fun onTouchEvent(event: MotionEvent): Boolean {
    when (event.action) {
      MotionEvent.ACTION_DOWN -> {
        startDialogAnimation()
      }
      MotionEvent.ACTION_UP -> {
        rollbackDialogAnimation()
      }
    }
    return true
  }

  /*
  * Start showing the dialog animation.
  */
  private fun startDialogAnimation() {
    listener?.onAnimationStart(srcImage?.originalUrl)
  }

  /*
  * Rollback the dialog animation.
  */
  private fun rollbackDialogAnimation() {
    listener?.onAnimationStop()
  }
}