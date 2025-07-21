<?php
$login      = $_POST['login'] ?? '';
$motDePasse = $_POST['motDePasse'] ?? '';
if ($login === 'admin' && $motDePasse === 'passer123') {
    http_response_code(200);
    echo "Connexion réussie";
} else {
    http_response_code(401);
    echo "Échec de la connexion";
}
?>
