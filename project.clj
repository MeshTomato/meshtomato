(defproject meshtomato "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145" :exclusions [org.apache.ant/ant]]]
  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-externs "0.1.3"]]
  :source-paths ["src"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {
               :builds {
                        :main {
                               :id "meshtomato"
                               :source-paths ["src"]
                               :incremental true
                               :jar true
                               :assert true
                               :compiler {:output-to "app/js/cljsbuild-main.js"
                                          :externs ["app/js/externs.js"
                                                    "node_modules/closurecompiler-externs/path.js"
                                                    "node_modules/closurecompiler-externs/process.js"]
                                          :warnings true
                                          :elide-asserts true
                                          :target :nodejs

                                          ;; no optimize compile (dev)
                                          ;;:optimizations :none
                                          ;; when no optimize uncomment
                                          ;;:output-dir "app/js/out"

                                          ;; simple compile (dev)
                                          :optimizations :simple

                                          ;; advanced compile (prod)
                                          ;:optimizations :advanced

                                          ;:source-map "app/js/test.js.map"
                                          :pretty-print true
                                          :output-wrapper true
                                          }}
                        :renderer {
                               :id "meshtomato"
                               :source-paths ["src-renderer"]
                               :incremental true
                               :jar true
                               :assert true
                               :compiler {:output-to "app/js/renderer.js"
                                          :warnings true
                                          :elide-asserts true

                                          ;; no optimize compile (dev)
                                          ;;:optimizations :none
                                          ;; when no optimize uncomment
                                          ;;:output-dir "app/js/out"

                                          ;; simple compile (dev)
                                          :optimizations :simple

                                          ;; advanced compile (prod)
                                          ;:optimizations :advanced

                                          ;:source-map "app/js/test.js.map"
                                          :pretty-print true
                                          :output-wrapper true
                                          }}
                        :test {
                               :source-paths ["src/meshtomato/core" "test"]
                               :compiler {:output-to "target/test-suite.js"
                                          :warnings true
                                          :target :nodejs
                                          :optimizations :simple
                                          :pretty-print true}}}
              :test-commands {"unit-tests" ["node" "target/test-suite.js"]}})
