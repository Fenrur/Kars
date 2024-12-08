#!/bin/bash

echo "------ Installing Cloudnative PG ------"
echo ""

helm upgrade cloudnative-pg cloudnative-pg \
  --install \
  --namespace cloudnative-pg \
  --create-namespace \
  --version 0.22.1 \
  -f values.yaml \
  --repo https://cloudnative-pg.io/charts/

echo ""
echo "------ Cloudnative PG installed ------"
echo ""
