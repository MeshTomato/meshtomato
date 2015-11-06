(ns meshtomato.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [meshtomato.core.timer :as timer]))

(deftest test-add
  (is (= (timer/add 1 1) 2)))

(enable-console-print!)

(defn -main [& args]
  (cljs.test/run-tests))

(set! *main-cli-fn* -main)
