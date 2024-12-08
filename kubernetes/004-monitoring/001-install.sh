#!/bin/bash

echo "------ Installing Monitoring ------"
echo ""

helm upgrade kube-stack-prometheus kube-prometheus-stack \
  --install \
  --namespace monitoring \
  --create-namespace \
  --version 66.3.0 \
  -f values.yaml \
  --repo https://prometheus-community.github.io/helm-charts

echo ""
echo "------ Monitoring installed ------"
echo ""
