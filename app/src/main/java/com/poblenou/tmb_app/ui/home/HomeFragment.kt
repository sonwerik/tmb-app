package com.poblenou.tmb_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poblenou.tmb_app.LineaMetroAdapter
import com.poblenou.tmb_app.R
import com.poblenou.tmb_app.RSSNotification
import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import java.net.URL

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(context)
        viewAdapter = LineaMetroAdapter()

        recyclerView = view.findViewById<RecyclerView>(R.id.lineas_metro_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
    private fun getRSSNotifications(): List<RSSNotification> {
        val feedUrl = "https://rss.app/feeds/ko74r8raKrpn3cer.xml"
        val notifications = mutableListOf<RSSNotification>()

        try {
            val url = URL(feedUrl)
            val input = XmlReader(url)
            val feed: SyndFeed = SyndFeedInput().build(input)

            for (entry: SyndEntry in feed.entries) {
                val title = entry.title
                val description = entry.description.value
                val date = entry.publishedDate.toString()

                val notification = RSSNotification(title, description, date)
                notifications.add(notification)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return notifications
    }
}
