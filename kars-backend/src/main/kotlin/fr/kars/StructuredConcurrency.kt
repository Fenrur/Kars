package fr.kars

import java.util.concurrent.StructuredTaskScope

fun<T> shutdownOnFailureTaskScope(fn: (StructuredTaskScope.ShutdownOnFailure) -> T): T {
    var result: T
    StructuredTaskScope.ShutdownOnFailure().use { scope ->
        result = fn(scope)
    }
    
    return result
}