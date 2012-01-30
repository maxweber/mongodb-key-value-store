(defproject org.clojars.doo/mongodb-key-value-store "0.1.1-SNAPSHOT"
  :description "Provides some functions to turn MongoDB into a plain key value store for Clojure data structures."
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojars.doo/congomongo "0.1.8-SNAPSHOT"]]
  :dev-dependencies [[com.stuartsierra/lazytest "1.1.2"]
                     [swank-clojure "1.4.0-SNAPSHOT"]
                     [lein-clojars "0.7.0"]])
