(ns mongodb-key-value-store.core
  (:use somnium.congomongo))

(defn get-value [collection key]
  (when-let [value (:value (fetch-one collection :where {:_id key}))]
    (read-string value)))

(defn put-value [collection key value]
  (update! collection
           {:_id key}
           {:_id key
            :value (pr-str value)}))

(defn remove-value [collection key]
  (destroy! collection
            {:_id key}))
