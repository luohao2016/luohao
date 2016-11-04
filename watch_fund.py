def initialize(context):

    
    set_benchmark('511880.XSHG')
    
    set_order_cost(OrderCost(open_tax=0.0, close_tax=0.0, open_commission=0, close_commission=0, close_today_commission=0, min_commission=0), type='fund')
    #set_order_cost(OrderCost(open_tax=0.0, close_tax=0.0, open_commission=0, close_commission=0, close_today_commission=0, min_commission=0), type='stock')    
    
    g.stocks = ['511990.XSHG','511900.XSHG','511810.XSHG','511980.XSHG','511820.XSHG','511860.XSHG','511800.XSHG']
    
    # 设置我们要操作的股票池
    set_universe(g.stocks)
    send_message("测试消息")

def after_trading_end(context):
    #得到当天所有成交记录
    trades = get_trades()
    for _trade in trades.values():
        log.info(str(_trade.time)+"   "+str(_trade.order_id)+"   "+str(_trade.price)+"   "+str(_trade.amount))
        
# 每个单位时间(如果按天回测,则每天调用一次,如果按分钟,则每分钟调用一次)调用一次
def handle_data(context, data):
    
    for security in g.stocks:
        price = data[security].close
        if(price<=99.988 and context.portfolio.cash >10000):
            log.info("$$$买入 %s:%s" % (security,price))
            order(security,5000,LimitOrderStyle(price))
            
            
        elif(price>=99.992 and  context.portfolio.positions[security].closeable_amount>0):
            log.info("!!!卖出 %s:%s" % (security,price))
            order(security,-5000,LimitOrderStyle(price))
            
            
    
