package app.nikhil.instagramgalleryanimation.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

    Glide.with(this@MainActivity)
      .load(imageUrl)
      .into(imageView_expanded)

    val blurAnimator = ObjectAnimator.ofFloat(blurView, "alpha", 0F, 0.6F)
    blurAnimator.start()
  }

  override fun onAnimationStart(imageUrl: String?) {
    initDialogAnimation(imageUrl)
  }

  override fun onAnimationStop() {
    blurView.visibility = View.GONE
    imageView_expanded.visibility = View.GONE
  }
}
