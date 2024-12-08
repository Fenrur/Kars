#!/bin/bash

echo "------ Installing External Dns ------"
echo ""

helm upgrade external-dns bitnami/external-dns \
  --install \
  --namespace external-dns \
  --create-namespace \
  --version 8.6.0 \
  -f values.yaml

echo ""
echo "------ External Dns installed ------"
echo ""
