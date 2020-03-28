package app.nikhil.instagramgalleryanimation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import app.nikhil.instagramgalleryanimation.R
import app.nikhil.instagramgalleryanimation.ui.ImageRecyclerView.ImageViewHolder
import app.nikhil.instagramgalleryanimation.utils.Image
import kotlinx.android.synthetic.main.list_item_image_recycler.view.instagramView

class ImageRecyclerView(
  private val images: List<Image>,
  private val listener: InstagramView.InstagramViewListener
) : RecyclerView.Adapter<ImageViewHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ) = ImageViewHolder(
    LayoutInflater.from(parent.context).inflate(
      R.layout.list_item_image_recycler, parent, false
    )
  )

  override fun getItemCount(): Int = images.size

  override fun onBindViewHolder(
    holder: ImageViewHolder,
    position: Int
  ) {
    holder.bind()
  }

  inner class ImageViewHolder(private val view: View) : ViewHolder(view) {
    fun bind() {
      view.instagramView.setImageSrc(images[adapterPosition])
      view.instagramView.setInstagramViewListener(listener)
    }
  }
}