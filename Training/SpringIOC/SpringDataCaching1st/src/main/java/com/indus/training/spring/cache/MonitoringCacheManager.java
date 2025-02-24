package com.indus.training.spring.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MonitoringCacheManager implements CacheManager {
    private final CacheManager delegate;
    private final Map<String, CacheStats> stats = new ConcurrentHashMap<>();

    public MonitoringCacheManager(CacheManager delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cache getCache(String name) {
        return new MonitoringCache(delegate.getCache(name), stats.computeIfAbsent(name, k -> new CacheStats()));
    }

    @Override
    public Collection<String> getCacheNames() {
        return delegate.getCacheNames();
    }

    public Map<String, CacheStats> getStats() {
        return stats;
    }

    private static class MonitoringCache implements Cache {
        private final Cache delegate;
        private final CacheStats stats;

        MonitoringCache(Cache delegate, CacheStats stats) {
            this.delegate = delegate;
            this.stats = stats;
        }

        @Override
        public ValueWrapper get(Object key) {
            ValueWrapper value = delegate.get(key);
            if (value != null) {
                stats.hit();
            } else {
                stats.miss();
            }
            return value;
        }

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getNativeCache() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T get(Object key, Class<T> type) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T get(Object key, Callable<T> valueLoader) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void put(Object key, Object value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void evict(Object key) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

    }

    public static class CacheStats {
        private final AtomicLong hits = new AtomicLong();
        private final AtomicLong misses = new AtomicLong();

        void hit() {
            hits.incrementAndGet();
        }

        void miss() {
            misses.incrementAndGet();
        }

        public long getHits() {
            return hits.get();
        }

        public long getMisses() {
            return misses.get();
        }
    }
}