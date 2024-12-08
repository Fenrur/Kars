#!/bin/bash

echo "------ Installing Cert Manager webhook OVH ------"
echo ""

helm upgrade cert-manager-webhook-ovh cert-manager-webhook-ovh \
  --install \
  --namespace cert-manager \
  --create-namespace \
  --version 0.7.1 \
  -f values.yaml \
  --repo https://aureq.github.io/cert-manager-webhook-ovh/

echo ""
echo "------ Cert Manager webhook OVH installed ------"
echo ""
