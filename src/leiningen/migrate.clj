(ns leiningen.migrate)

(defn migrate
  "I don't do a lot."
  [project & args]
  (leiningen.core.main/info "Helllo")
  (leiningen.core.main/warn "Cool")
  (println "Hello migrate!"))
