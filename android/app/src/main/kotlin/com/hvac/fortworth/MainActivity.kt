package com.hvac.fortworth

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin
import io.flutter.plugins.googlemobileads.NativeAdFactory
import com.google.android.gms.ads.nativead.NativeAd

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        // Register NativeAdFactory untuk listTile
        val factory = ListTileNativeAdFactory(this)
        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "listTile", factory)
    }

    override fun cleanUpFlutterEngine(flutterEngine: FlutterEngine) {
        // Unregister saat dispose
        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "listTile")
    }
}

// NativeAdFactory untuk listTile
class ListTileNativeAdFactory(private val context: Context) : NativeAdFactory {
    override fun createNativeAd(
        nativeAd: NativeAd,
        customOptions: Map<String, Any>?
    ): View {
        val adView = LayoutInflater.from(context)
            .inflate(R.layout.native_ad_list_tile, null)

        val headlineView: TextView = adView.findViewById(R.id.ad_headline)
        val bodyView: TextView = adView.findViewById(R.id.ad_body)
        val iconView: ImageView = adView.findViewById(R.id.ad_icon)

        headlineView.text = nativeAd.headline
        bodyView.text = nativeAd.body
        nativeAd.icon?.let { iconView.setImageDrawable(it.drawable) }

        return adView
    }
}
