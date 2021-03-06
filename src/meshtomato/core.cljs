(ns meshtomato.core
  (:require [cljs.nodejs :as nodejs]
            [meshtomato.core.bounce :as bounce]))

(def path (nodejs/require "path"))

(def BrowserWindow (nodejs/require "browser-window"))

(def crash-reporter (nodejs/require "crash-reporter"))

(def *win* (atom nil))

(def app (nodejs/require "app"))

(def js-app (js/require "app"))
(def js-ipc (js/require "ipc"))

(defn -main []
  (.start crash-reporter)

  (bounce/init js-app js-ipc)

  ;; error listener
  (.on nodejs/process "error"
    (fn [err] (.log js/console err)))

  ; window all closed listener
   (.on app "window-all-closed"
     (fn [] (if (not= (.-platform nodejs/process) "darwin")
              (.quit app))))

  ; ready listener
   (.on app "ready"
     (fn []
       (reset! *win* (BrowserWindow. (clj->js {:width 800 :height 600})))

       ;; when no optimize comment out
       (.loadUrl @*win* (str "file://" (.resolve path (js* "__dirname") "../index.html")))

       ;; when no optimize uncomment
       ;; (.loadUrl @*win* (str "file://" (.resolve path (js* "__dirname") "../../../index.html")))

       (.on @*win* "closed" (fn [] (reset! *win* nil))))))

(nodejs/enable-util-print!)

(set! *main-cli-fn* -main)
