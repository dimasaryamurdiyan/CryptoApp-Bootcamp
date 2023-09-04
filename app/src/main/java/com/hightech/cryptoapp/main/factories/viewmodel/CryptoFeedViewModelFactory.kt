package com.hightech.cryptoapp.main.factories.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.singaludra.featurefeed.presentation.CryptoFeedViewModel
import com.hightech.cryptoapp.main.factories.CryptoFeedLoaderCacheDecoratorFactory
import com.hightech.cryptoapp.main.factories.CryptoFeedLoaderWithFallbackCompositeFactory
import com.hightech.cryptoapp.main.factories.LocalCryptoFeedLoaderFactory
import com.hightech.cryptoapp.main.factories.RemoteCryptoFeedLoaderFactory

class CryptoFeedViewModelFactory {
    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                com.singaludra.featurefeed.presentation.CryptoFeedViewModel(
                    CryptoFeedLoaderWithFallbackCompositeFactory.createCryptoFeedLoaderWithFallbackComposite(
                        primary = CryptoFeedLoaderCacheDecoratorFactory.createCryptoFeedLoaderDecorator(
                            decorate = RemoteCryptoFeedLoaderFactory.createRemoteCryptoFeedLoader(),
                            cache = LocalCryptoFeedLoaderFactory.createInsertCryptoFeed()
                        ),
                        fallback = LocalCryptoFeedLoaderFactory.createLocalCryptoFeedLoader()
                    )
                )
            }
        }
    }
}