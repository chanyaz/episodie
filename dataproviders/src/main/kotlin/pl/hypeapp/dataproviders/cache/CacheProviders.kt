package pl.hypeapp.dataproviders.cache

import io.reactivex.Single
import io.rx_cache2.*
import pl.hypeapp.dataproviders.entity.MostPopularEntity
import pl.hypeapp.dataproviders.entity.TopListEntity
import pl.hypeapp.dataproviders.entity.TvShowEntity
import java.util.concurrent.TimeUnit

interface CacheProviders {

    @Expirable(true)
    fun getTvShow(tvShowEntity: Single<TvShowEntity>, query: DynamicKey, update: EvictDynamicKey): Single<TvShowEntity>

    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    fun getMostPopular(mostPopularEntity: Single<MostPopularEntity>, query: DynamicKeyGroup, evictDynamicKeyGroup: EvictDynamicKeyGroup): Single<MostPopularEntity>

    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    fun getTopList(topListEntity: Single<TopListEntity>, query: DynamicKeyGroup, evictDynamicKeyGroup: EvictDynamicKeyGroup): Single<TopListEntity>

}