package fr.kars

class Logger(name: String) {
    private val logger = System.getLogger(name)

    fun info(msg: () -> Any?) = logger.log(System.Logger.Level.INFO) { msg().toString() } 
    fun info(th: Throwable, msg: () -> Any?) = logger.log(System.Logger.Level.INFO, { msg().toString() }, th)
    
    fun error(msg: () -> Any?) = logger.log(System.Logger.Level.ERROR) { msg().toString() }
    fun error(th: Throwable, msg: () -> Any?) = logger.log(System.Logger.Level.ERROR, { msg().toString() }, th)
    
    fun debug(msg: () -> Any?) = logger.log(System.Logger.Level.DEBUG) { msg().toString() }
    fun debug(th: Throwable, msg: () -> Any?) = logger.log(System.Logger.Level.DEBUG, { msg().toString() }, th)
    
    fun trace(msg: () -> Any?) = logger.log(System.Logger.Level.TRACE) { msg().toString() }
    fun trace(th: Throwable, msg: () -> Any?) = logger.log(System.Logger.Level.TRACE, { msg().toString() }, th)
    
    fun warn(msg: () -> Any?) = logger.log(System.Logger.Level.WARNING) { msg().toString() }
    fun warn(th: Throwable, msg: () -> Any?) = logger.log(System.Logger.Level.WARNING, { msg().toString() }, th)
}