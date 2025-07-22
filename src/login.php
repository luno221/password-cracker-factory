<?php
// login.php
if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    $login = $_GET['login'] ?? '';
    $password = $_GET['password'] ?? '';

    // Identifiants définis en dur pour l'exemple
    $validLogin = 'admin';
    $validPassword = 'passer1234';

    // Vérification des identifiants
    if ($login === $validLogin && $password === $validPassword) {
        echo "Connexion réussie";
    } else {
        echo "Échec de la connexion";
    }
}
?>
