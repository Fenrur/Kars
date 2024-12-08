#!/bin/bash

echo "------ Installing Config Reloader Controller ------"
echo ""

helm upgrade reloader reloader \
  --install \
  --namespace reloader-system \
  --create-namespace \
  --version 1.2.0 \
  --repo https://stakater.github.io/stakater-charts

echo ""
echo "------ Config Reloader Controller installed ------"
echo ""