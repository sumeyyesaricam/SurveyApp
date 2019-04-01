const functions = require("firebase-functions");

const admin = require("firebase-admin");
admin.initializeApp(functions.config().firebase);

exports.addSurvey = functions.firestore
  .document("survey/{surveyId}")
  .onCreate((docSnapshot, context) => {
    const survey = docSnapshot.data();

    admin
      .firestore()
      .collection("user")
      .get()
      .then(snapshot => {
        snapshot.forEach(doc => {
          const user = doc.data();
          const registractionTokens = user.token;
          const payload = {
            notification: {
              body: survey.content + " içerikli anket eklendi. ",
              title: "Anket eklendi."
            }
          };
          return admin
            .messaging()
            .sendToDevice(registractionTokens, payload)
            .then(response => {
              console.log(" Anket eklendi.", response);

              return admin
                .firestore()
                .collection("notification")
                .add({
                  content: "Anket eklendi.",
                  timestamp: admin.firestore.FieldValue.serverTimestamp()
                });
            })
            .catch(function(error) {
              console.log("addSurvey. Hata oluştu:", error);
            });
        });
      })
      .catch(function(error) {
        console.log(" Hata oluştu:", error);
      });
    return "";
  });


  exports.updateSurvey= functions.firestore
  .document("survey/{surveyId}")
  .onUpdate((docSnapshot, context) => {
    const _surveyAfter = docSnapshot.after.data();
    const _surveyBefore = docSnapshot.before.data();
    console.log("Anket değiştikten sonra anket içeriği " + _surveyAfter.content);
    console.log("Anket değiştikten önce anket içeriği " + _surveyBefore.content);
    
  });
  exports.deleteSurvey = functions.firestore
  .document('survey/{surveyId}')
  .onDelete((snap, context) => {
    const deletedValue = snap.data();
    console.log("Silinen anket içeriği " + deletedValue.content);

  });