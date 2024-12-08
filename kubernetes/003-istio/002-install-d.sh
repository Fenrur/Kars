#!/bin/bash

echo "------ Installing Istio base ------"
echo ""

helm upgrade istiod istiod \
  --install \
  --namespace istio-system \
  --create-namespace \
  --version 1.24.1 \
  --set profile=minimal \
  --repo https://istio-release.storage.googleapis.com/charts

echo ""
echo "------ Istio base installed ------"
echo ""