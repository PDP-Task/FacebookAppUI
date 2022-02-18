package uz.context.facebookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uz.context.facebookapp.adapter.FeedAdapter
import uz.context.facebookapp.adapter.StaggerAdapter
import uz.context.facebookapp.model.Feed
import uz.context.facebookapp.model.Post
import uz.context.facebookapp.model.Stagger
import uz.context.facebookapp.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val stories: ArrayList<Story> = ArrayList()
    private val feeds: ArrayList<Feed> = ArrayList()
    private lateinit var recyclerSt: RecyclerView
    private lateinit var staggerAdapter: StaggerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        staggerAdapter = StaggerAdapter(images())
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        stories.add(Story(R.drawable.img_android, getString(R.string.android_programming)))
        stories.add(Story(R.drawable.img_java, getString(R.string.java_pr)))
        stories.add(Story(R.drawable.kotlin_img, getString(R.string.kotlin_pr)))
        stories.add(Story(R.drawable.img_java, getString(R.string.java_pr)))
        stories.add(Story(R.drawable.kotlin_img, getString(R.string.kotlin_pr)))
        stories.add(Story(R.drawable.img_android, getString(R.string.android_programming)))
        feeds.add(Feed())
        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.kotlin_img, "Android", R.drawable.kotlin_img)))
        feeds.add(Feed(Post(R.drawable.img_java, "Android", R.drawable.img_java)))
        feeds.add(Feed(Post(R.drawable.img_android, "Android", R.drawable.img_android)))
        feeds.add(Feed(Post(R.drawable.img_java, "Android", R.drawable.img_java)))
        feeds.add(Feed(Post(R.drawable.kotlin_img, "Android", R.drawable.kotlin_img)))
        feeds.add(Feed(Post(R.drawable.img_java, "Android", R.drawable.img_java)))
        feeds.add(Feed(Post(R.drawable.img_android, "Android", R.drawable.img_android)))
        return feeds
    }
    private fun images(): ArrayList<Stagger> {
        val staggerList: ArrayList<Stagger> = ArrayList()
        for (i in 0..5) {
            staggerList.add(Stagger(R.drawable.img_android))
        }
        return staggerList
    }
}
