package ggboy.common.context;

import ggboy.common.context.holder.ContextHolder;
import ggboy.common.context.holder.ThreadLocalContextHolder;
import ggboy.common.utils.string.StringUtil;

public class StringBuilderContext {
	
	private static ContextHolder<StringBuilder> context;
	private final static String DEFAULT_STRATEGY_NAME = StringBuilder.class.getName();
	
	static {
		setStrategyName(null);
	}
	
	public final static StringBuilder getContext() {
		return context.getContext();
	}
	
	public synchronized static void setStrategyName(String strategyName) {
		if (StringUtil.isEmpty(strategyName)) {
			strategyName = DEFAULT_STRATEGY_NAME;
		}
		
		if (context == null) {
			context = new ThreadLocalContextHolder<StringBuilder>(strategyName);
		} else {
			context.createContext(strategyName);
		}
	}
}