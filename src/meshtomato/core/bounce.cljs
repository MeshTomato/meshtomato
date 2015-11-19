(ns meshtomato.core.bounce)

(defn init [app ipc]
  (.log js/console "loaded bounce-core")
  (.on ipc "bounce-dock" (fn [event arg]
                           (.log js/console "should bounce")
                           (.log js/console (.. app -dock bounce)))))
