package site.xuanwo.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单缓存
 * 
 * @author xuanwo
 *
 */
public class SimpleLocalCache<T> {

	/** 默认初始容量 */
	private final static int INITIAL_CAPACITY = 16;
	/** 默认扩容系数 */
	private final static float LOAD_FACTOR = 0.75f;

	/** 默认失效时间5分钟 */
	private long defaultExpirationTime = 300000;

	private Map<Object, SimpleLocalCache<T>.Data<T>> cache;

	/**
	 * 设置默认失效时间，当使用不需设置失效时间的方法设置缓存时，默认的缓存有效时间
	 * 
	 * @param defaultExpirationTime
	 */
	public void setExpirationTime(long defaultExpirationTime) {
		this.defaultExpirationTime = defaultExpirationTime;
	}

	public SimpleLocalCache() {
	}

	/**
	 * 初始化cache
	 * 
	 * @param initialCapacity map初始容量
	 */
	public SimpleLocalCache(int initialCapacity) {
		this(initialCapacity, LOAD_FACTOR);
	}

	/**
	 * 
	 * @param initialCapacity map初始容量
	 * @param loadFactor      map的扩容系数
	 */
	public SimpleLocalCache(int initialCapacity, float loadFactor) {
		cache = new HashMap<Object, Data<T>>(initialCapacity, loadFactor);
		cache.clear();
	}

	public class Data<T> {
		/** 缓存过期时间，-1为永不失效 */
		long expirationTime;
		T data;
	}

}
