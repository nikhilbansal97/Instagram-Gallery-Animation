package app.nikhil.instagramgalleryanimation.utils

val TEST_IMAGES_SQUARE = listOf(
  "https://images.unsplash.com/photo-1582885745933-e43bee4517ae?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1491438590914-bc09fcaaf77a?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1501386761578-eac5c94b800a?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1512626120412-faf41adb4874?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1502635385003-ee1e6a1a742d?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1529835299686-53bd13fb3ee1?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1507608869274-d3177c8bb4c7?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1503721827581-14e4c8676769?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80",
  "https://images.unsplash.com/photo-1530023367847-a683933f4172?ixlib=rb-1.2.1&fit=crop&w=1000&h=1000&q=80"
)

val TEST_IMAGES_ORIGINAL = listOf(
  "https://images.unsplash.com/photo-1582885745933-e43bee4517ae?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1491438590914-bc09fcaaf77a?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1501386761578-eac5c94b800a?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1512626120412-faf41adb4874?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1502635385003-ee1e6a1a742d?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1529835299686-53bd13fb3ee1?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1507608869274-d3177c8bb4c7?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1503721827581-14e4c8676769?ixlib=rb-1.2.1",
  "https://images.unsplash.com/photo-1530023367847-a683933f4172?ixlib=rb-1.2.1"
)

val TEST_IMAGES = arrayListOf<Image>().apply {
  for (i in TEST_IMAGES_SQUARE.indices) {
    add(Image(shortUrl = TEST_IMAGES_SQUARE[i], originalUrl = TEST_IMAGES_ORIGINAL[i]))
    add(Image(shortUrl = TEST_IMAGES_SQUARE[i], originalUrl = TEST_IMAGES_ORIGINAL[i]))
  }
}
  .shuffled()