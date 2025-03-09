const express = require("express");
const admin = require("firebase-admin");
const cors = require("cors");
require("dotenv").config();

// Initialize Firebase
const serviceAccount = require("./serviceAccountKey.json");
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

const db = admin.firestore();
const app = express();

app.use(cors());
app.use(express.json());

// Start game end-point
app.post("/startGame", async (req, res) => {
  try {
    const gameRef = db.collection("games").doc("game1");
    await gameRef.set({ status: "started", players: req.body.players });
    res.status(200).send({ message: "Game started!" });
  } catch (error) {
    res.status(500).send({ error: error.message });
  }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
