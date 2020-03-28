package app.nikhil.instagramgalleryanimation.ui

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import app.nikhil.instagramgalleryanimation.R
import app.nikhil.instagramgalleryanimation.utils.TEST_IMAGES
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.blurView
import kotlinx.android.synthetic.main.activity_main.imageView_expanded
import kotlinx.android.synthetic.main.activity_main.imagesRecyclerView

class MainActivity : AppCompatActivity(), InstagramView.InstagramViewListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    imagesRecyclerView.adapter = ImageRecyclerView(TEST_IMAGES, this)
  }

  private fun initDialogAnimation(imageUrl: String?) {
    blurView.visibility = View.VISIBLE
    imageView_expanded.visibility = View.VISIBLE

    // Load the image in the image view.
    Glide.with(this@MainActivity)
      .load(imageUrl)
      .into(imageView_expanded)

    startBlurAnimation()
    startMarginAnimation()
  }

  private fun startMarginAnimation() {
    val marginAnimator = ValueAnimator.ofInt(80, 40)
      .apply {
        interpolator = OvershootInterpolator(2F)
        duration = 300
        addUpdateListener {
          val value = it.animatedValue as Int
          val params = (imageView_expanded.layoutParams as ConstraintLayout.LayoutParams).apply {
            leftMargin = value
            rightMargin = value
          }
          imageView_expanded.layoutParams = params
        }
      }
    marginAnimator.start()
  }

  private fun startBlurAnimation() {
    val blurAnimator = ObjectAnimator.ofFloat(blurView, View.ALPHA.name, 0F, 0.6F)
    blurAnimator.start()
  }

  override fun onAnimationStart(imageUrl: String?) {
    initDialogAnimation(imageUrl)
  }

  override fun onAnimationStop() {
    reverseBlurAnimation()
    reverseMarginAnimation()

    blurView.visibility = View.GONE
    imageView_expanded.visibility = View.GONE
  }

  private fun reverseMarginAnimation() {
    val marginAnimator = ValueAnimator.ofInt(40, 80)
      .apply {
        interpolator = AccelerateInterpolator()
        duration = 300
        addUpdateListener {
          val value = it.animatedValue as Int
          val params = (imageView_expanded.layoutParams as ConstraintLayout.LayoutParams).apply {
            leftMargin = value
            rightMargin = value
          }
          imageView_expanded.layoutParams = params
        }
      }
    marginAnimator.start()
  }

  private fun reverseBlurAnimation() {
    val blurAnimator = ObjectAnimator.ofFloat(blurView, View.ALPHA.name, 0.6F, 0F)
    blurAnimator.start()
  }
}
