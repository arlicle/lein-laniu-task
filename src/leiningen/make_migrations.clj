(ns leiningen.make-migrations
  (:require [clojure.java.io :as io]
            [clojure.tools.namespace.find :as ns-find]
            [clojure.tools.namespace.file :as ns-file]
            ))



;
;(def p ["/code/clojure/test-app/src/"])
;(def a
;  (filter
;    #(= "models.clj" (.getName %))
;    (apply clojure.set/union
;           (map (comp #(ns-find/find-sources-in-dir % ns-find/clj)
;                      io/file)
;                p))))
;
;
;(map (comp #(ns-find/find-sources-in-dir % ns-find/clj)
;           io/file)
;     p)
;
;(load-file (str (first a)))
;
;(doseq [f a]
;  (println (.getName f)))

(defn make-migrations
  "I don't do a lot."
  [project & args]
  (let [aaa
        (->> (all-ns)
             (map ns-name)
             (map name)
             (filter #(clojure.string/ends-with? % ".models")))

        ;source-files (apply clojure.set/union
        ;                    (map (comp #(ns-find/find-sources-in-dir % ns-find/clj)
        ;                               io/file)
        ;                         (project :source-paths)))
        ;model-ns-names (->> source-files
        ;                    (map (comp second ns-file/read-file-ns-decl))
        ;                    (filter #(clojure.string/ends-with? (str %) ".models"))
        ;                    )

        ;cccc (apply clojure.set/union
        ;            (map (comp second ns-file/read-file-ns-decl)
        ;                 (project :source-paths)))
        ]

    (load-file "/code/clojure/test-app/src/test_app/models.clj")

    ;(println cccc)
    ;(println aaa)
    ;(println source-files)
    ;(println model-ns-names)

    ;(doseq [a-ns-name model-ns-names]
    ;  (require (list a-ns-name))
    ;  (println (ns-interns a-ns-name))
    ;  )
    ;(doseq [f source-files]
    ;  (load-file (str f )))
    ;(require ['test-app.models])

    )

  (println (:source-paths project))
  (println args)
  (println "Hello makemigrations!"))

(defn get-var-namespace
  [qualified-var]
  {:pre [(var? qualified-var)]}
  (-> qualified-var meta :ns))