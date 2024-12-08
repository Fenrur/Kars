#!/bin/bash

echo "------ Installing Argo CD ------"
echo ""

helm upgrade argocd argo/argo-cd \
  --install \
  --namespace argocd \
  --create-namespace \
  --version 7.7.6 \
  -f values.yaml \
  --repo https://argoproj.github.io/argo-helm

echo ""
echo "------ Argo CD installed ------"
echo ""
