app.config(function ($routeProvider) {
  $routeProvider
  .when('/dashbord', {
	   templateUrl: PartialsPath + '/dashbord.html',
	   controller: 'myController',
	   })
//   .when('/login', {
//	   templateUrl: PartialsPath + '/index.html',
//	   //controller: 'myController',
//	   })
  .when('/paiements/:id', {
	   templateUrl: PartialsPath + '/paiement.html',
	   controller: 'PaiementsCtrl',
	   })
   .when('/paiementscredit', {
	   templateUrl: PartialsPath + '/paiementcredit.html',
	   controller: 'PaiementsCreditCtrl',
	   })
  .when('/getpaiements', {
	   templateUrl: PartialsPath + '/paiementcommande.html',
	   controller: 'PaiementsCommandeCtrl',
	   })
  .when('/commandes', {
	   templateUrl: PartialsPath + '/commandes.html',
	   controller: 'CommandesCtrl',
	   })
  .when('/commande', {
	   templateUrl: PartialsPath + '/commandesdetails.html',
	   controller: 'CommandesDetailAchatCtrl',
	   })
  .when('/commandevente', {
	   templateUrl: PartialsPath + '/commandesdetailsventes.html',
	   controller: 'CommandesDetailVenteCtrl',
	   })
  .when('/commandeform', {
	   templateUrl: PartialsPath + '/commandeentree.html',
	   controller: 'CommandeEntreeCtrl',
	   })
   .when('/commandesortieform', {
	   templateUrl: PartialsPath + '/commandesortie.html',
	   controller: 'CommandeSortieCtrl',
	   })
  .when('/commandescredit', {
	   templateUrl: PartialsPath + '/commandescredit.html',
	   controller: 'CommandesCreditCtrl',
	   })
  .when('/entrees/:id', {
	   templateUrl: PartialsPath + '/entrees.html',
	   controller: 'EntreesCtrl',
	   })
  .when('/sorties/:id', {
	   templateUrl: PartialsPath + '/sorties.html',
	   controller: 'SortiesCtrl',
	   })
  .when('/perimes', {
	   templateUrl: PartialsPath + '/listearticlesperime.html',
	   controller: 'ArticlePerimeCtrl',
  })
  .when('/taxes', {
	   templateUrl: PartialsPath + '/taxes.html',
	   controller: 'TaxesCtrl',
	   })
   .when('/taxes/:id', {
	    templateUrl: PartialsPath + '/taxe.html',
	    controller: 'TaxeCtrl',
	    })
   .when('/promotions', {
	   templateUrl: PartialsPath + '/promotions.html',
	   controller: 'PromotionsCtrl',
	   })
   .when('/promotions/:id', {
	    templateUrl: PartialsPath + '/promotion.html',
	    controller: 'PromotionCtrl',
	    })
	  .when('/fournisseurs', {
	   templateUrl: PartialsPath + '/fournisseurs.html',
	   controller: 'FournisseursCtrl',
	   })
   .when('/fournisseurs/:id', {
	    templateUrl: PartialsPath + '/fournisseur.html',
	    controller: 'FournisseurCtrl',
	    })
	.when('/fournisseurform', {
	    templateUrl: PartialsPath + '/fournisseurform.html',
	    controller: 'FournisseursCtrl',
	    })
	.when('/articlesbyfournisseurselect', {
	    templateUrl: PartialsPath + '/articlesbyfournisseurselect.html',
	    controller: 'ArticlesByFournisseursCtrl',
	    }) 
	.when('/commandesbyfournisseur', {
	    templateUrl: PartialsPath + '/commandesbyfournisseurselect.html',
	    controller: 'CommandesByFournisseursCtrl',
	    }) 
    .when('/client', {
	   templateUrl: PartialsPath + '/clients.html',
	   controller: 'ClientFormCtrl',
	   })
	.when('/clients', {
	   templateUrl: PartialsPath + '/listeclients.html',
	   controller: 'ClientsCtrl',
	   })
	   .when('/clientscredit', {
	   templateUrl: PartialsPath + '/listeclientscredit.html',
	   controller: 'ClientsCreditCtrl',
	   })
	.when('/roles/:role', {
	   templateUrl: PartialsPath + '/role.html',
	   controller: 'RoleCtrl',
	   })
	.when('/roles', {
	   templateUrl: PartialsPath + '/roles.html',
	   controller: 'RolesCtrl',
	   })   
	.when('/users', {
	   templateUrl: PartialsPath + '/listeusers.html',
	   controller: 'UsersCtrl',
	   })
	.when('/user', {
	   templateUrl: PartialsPath + '/user.html',
	   controller: 'UserFormCtrl',
	   })
	.when('/users/:IdUser', {
	   templateUrl: PartialsPath + '/userupdate.html',
	   controller: 'UserCtrl',
	   })
	.when('/clientsbalaye', {
	   templateUrl: PartialsPath + '/listeclientsbalaye.html',
	   controller: 'ClientsBalayeCtrl',
	   })
	.when('/clientsnonbalaye', {
	   templateUrl: PartialsPath + '/listeclientsnonbalaye.html',
	   controller: 'ClientsNonBalayeCtrl',
	   })
   .when('/clients/:id', {
	    templateUrl: PartialsPath + '/client.html',
	    controller: 'ClientCtrl',
	    })
	.when('/typesclient', {
	   templateUrl: PartialsPath + '/typeClients.html',
	   controller: 'TypeClientsCtrl',
	   })
   .when('/typesclient/:id', {
	    templateUrl: PartialsPath + '/typeClient.html',
	    controller: 'TypeClientCtrl',
	    })	
   .when('/commandesbyclient', {
	    templateUrl: PartialsPath + '/commandeclient.html',
	    controller: 'CommandesClientCtrl',
	    })
	.when('/commandesbyclientcredit', {
	    templateUrl: PartialsPath + '/commandeclientcredit.html',
	    controller: 'CommandesClientCreditCtrl',
	    })
	.when('/etats', {
	   templateUrl: PartialsPath + '/etats.html',
	   controller: 'EtatsCtrl',
	   })
   .when('/etats/:id', {
	    templateUrl: PartialsPath + '/etat.html',
	    controller: 'EtatCtrl',
	    })  
   .when('/codes', {
	   templateUrl: PartialsPath + '/codes.html',
	   controller: 'CodesCtrl',
	   })
  
    .when('/villes', {
	   templateUrl: PartialsPath + '/villes.html',
	   controller: 'VillesCtrl',
	   })
	.when('/villes/:id', {
	    templateUrl: PartialsPath + '/ville.html',
	    controller: 'VilleCtrl',
	    })
	.when('/quartiers', {
	   templateUrl: PartialsPath + '/quartiers.html',
	   controller: 'QuartiersCtrl',
	   })
	.when('/quartiers/:id', {
	    templateUrl: PartialsPath + '/quartier.html',
	    controller: 'QuartierCtrl',
	    })
	.when('/sousCategories', {
	   templateUrl: PartialsPath + '/sousCategories.html',
	   controller: 'SousCategoriesCtrl',
	   })
	.when('/sousCategories/:id', {
	    templateUrl: PartialsPath + '/sousCategorie.html',
	    controller: 'SousCategorieCtrl',
	    })
	.when('/categories', {
	   templateUrl: PartialsPath + '/categories.html',
	   controller: 'CategoriesCtrl',
	   })
	.when('/categories/:id', {
	    templateUrl: PartialsPath + '/categorie.html',
	    controller: 'CategorieCtrl',
	    }) 
	.when('/articles', {
	   templateUrl: PartialsPath + '/articles.html',
	   controller: 'ArticlesCtrl',
	   })
	.when('/article', {
	   templateUrl: PartialsPath + '/articleform.html',
	   controller: 'ArticleFormCtrl',
	   })
	.when('/article/:id', {
	    templateUrl: PartialsPath + '/article.html',
	    controller: 'ArticleCtrl',
	    })	
	 .when('/prixarticle', {
		templateUrl: PartialsPath + '/prixarticle.html',
		controller: 'PrixArticlesCtrl',
	})
	.when('/defectueuse', {
		templateUrl: PartialsPath + '/defectueuse.html',
		controller: 'MouvementsCtrl',
	})
	.when('/mouvements/:id', {
	   templateUrl: PartialsPath + '/mouvements.html',
	   controller: 'MouvementsCtrl',
	   })
  /*
  .when('/sample_page', {
    templateUrl: ExamlesPath + '/sample_page.html',
    controller: 'SamplePageCtrl',
  })
  .when('/insert_row', {
    templateUrl: ExamlesPath + '/insert_row.html',
    controller: 'InsertRowCtrl',
  })
  .when('/update_row', {
    templateUrl: ExamlesPath + '/update_row.html',
    controller: 'UpdateRowCtrl',
  })
  .when('/delete_row', {
    templateUrl: ExamlesPath + '/delete_row.html',
    controller: 'DeleteRowCtrl',
  })
  .when('/retrive_row', {
    templateUrl: ExamlesPath + '/retrive_row.html',
    controller: 'RetriveRowsCtrl',
  })
  .when('/retrive_rows', {
    templateUrl: ExamlesPath + '/retrive_rows.html',
    controller: 'RetriveRowCtrl',
  })

  //pages
  .when('/categories',{
    templateUrl: PartialsPath + '/categories.html',
    controller: 'categoriesCtrl'
  })
  .when('/categories/:id',{
    templateUrl: PartialsPath + '/categorie.html',
    controller: 'categorieCtrl'
  })
  .when('/domaines',{
    templateUrl: PartialsPath + '/domaines.html',
    controller: 'domainesCtrl'
  })
  .when('/domaines/:id',{
    templateUrl: PartialsPath + '/domaine.html',
    controller: 'domaineCtrl'
  })
  .when('/competences',{
    templateUrl: PartialsPath + '/competences.html',
    controller: 'competencesCtrl'
  })  
  .when('/competences/:id',{
    templateUrl: PartialsPath + '/competence.html',
    controller: 'competenceCtrl'
  })    
  .when('/ecoles',{
    templateUrl: PartialsPath + '/ecoles.html',
    controller: 'ecolesCtrl'
  })
  .when('/ecoles/:id',{
    templateUrl: PartialsPath + '/ecole.html',
    controller: 'ecoleCtrl'
  })
  .when('/entreprises',{
    templateUrl: PartialsPath + '/entreprises.html',
    controller: 'entreprisesCtrl'
  })
  .when('/entreprises/:id',{
    templateUrl: PartialsPath + '/entreprise.html',
    controller: 'entrepriseCtrl'
  })
  .when('/experiences',{
    templateUrl: PartialsPath + '/experiences.html',
    controller: 'experiencesCtrl'
  })
  .when('/experiences/:id',{
    templateUrl: PartialsPath + '/experience.html',
    controller: 'experienceCtrl'
  })
  .when('/langues',{
    templateUrl: PartialsPath + '/langues.html',
    controller: 'languesCtrl'
  })
  .when('/langues/:id',{
    templateUrl: PartialsPath + '/langue.html',
    controller: 'langueCtrl'
  })
  .when('/projets',{
    templateUrl: PartialsPath + '/projets.html',
    controller: 'projetsCtrl'
  })
  .when('/projets/:id',{
    templateUrl: PartialsPath + '/projet.html',
    controller: 'projetCtrl'
  })
  .when('/tags',{
    templateUrl: PartialsPath + '/tags.html',
    controller: 'tagsCtrl'
  })
  .when('/tags/:id',{
    templateUrl: PartialsPath + '/tag.html',
    controller: 'tagCtrl'
  })
  .when('/types_formation',{
    templateUrl: PartialsPath + '/types_formation.html',
    controller: 'typesFormationCtrl'
  })
  .when('/types_formation/:id',{
    templateUrl: PartialsPath + '/type_formation.html',
    controller: 'typeformationCtrl'
  })
  .when('/formations',{
    templateUrl: PartialsPath + '/formations.html',
    controller: 'formationsCtrl'
  })
  .when('/formations/:id',{
    templateUrl: PartialsPath + '/formation.html',
    controller: 'formationCtrl'
  })
  .when('/candidatcompetences',{
     templateUrl: PartialsPath + '/candidatcompetences.html',
     controller: 'candidatcompetencesCtrl'
  })
  .when('/candidatcompetences/:id',{
    templateUrl: PartialsPath + '/candidatcompetence.html',
    controller: 'candidatcompetenceCtrl'
  })
  .when('/candidats',{
    templateUrl: PartialsPath + '/candidats.html',
    controller: 'candidatsCtrl'
  })
  .when('/candidatsbymission',{
    templateUrl: PartialsPath + '/candidatsbymission.html',
    controller: 'candidatsbymissionCtrl'
  })  
  .when('/candidats/:id',{
    templateUrl: PartialsPath + '/candidat.html',
    controller: 'candidatCtrl'
  })
  .when('/candidatlangues',{
     templateUrl: PartialsPath + '/candidatlangues.html',
     controller: 'candidatlanguesCtrl'
  })
  .when('/candidatlangues/:id',{
     templateUrl: PartialsPath + '/candidatlangue.html',
     controller: 'candidatlangueCtrl'
  })
  .when('/missionlangues',{
     templateUrl: PartialsPath + '/missionlangues.html',
     controller: 'MissionLanguesCtrl'
  })
  .when('/missionlangues/:id',{
     templateUrl: PartialsPath + '/missionlangue.html',
     controller: 'MissionLangueCtrl'
  })
  .when('/candidattags',{
     templateUrl: PartialsPath + '/candidattags.html',
     controller: 'candidattagsCtrl'
  })
  .when('/candidattags/:id',{
     templateUrl: PartialsPath + '/candidattag.html',
     controller: 'candidattagCtrl'
  })
  .when('/missiontags',{
     templateUrl: PartialsPath + '/missiontags.html',
     controller: 'missiontagsCtrl'
  })
  .when('/missiontags/:id',{
     templateUrl: PartialsPath + '/missiontag.html',
     controller: 'missiontagCtrl'
  })
  .when('/missiontypeformations',{
     templateUrl: PartialsPath + '/missiontypeformations.html',
     controller: 'missiontypeformationsCtrl'
  })
  .when('/missiontypeformations/:id',{
    templateUrl: PartialsPath + '/missiontypeformation.html',
    controller: 'missiontypeformationCtrl'
  })
  .when('/missioncompetences',{
    templateUrl: PartialsPath + '/missioncompetences.html',
    controller: 'missioncompetencesCtrl'
  })
  .when('/missioncompetences/:id',{
    templateUrl: PartialsPath + '/missioncompetence.html',
    controller: 'missioncompetencesCtrl'
  })
  .when('/clients', {
    templateUrl: PartialsPath + '/clients.html',
    controller: 'ClientsCtrl',
  })
  .when('/clients/:id', {
    templateUrl: PartialsPath + '/client.html',
    controller: 'clientCtrl',
  })
.when('/demandes', {
   templateUrl: PartialsPath + '/demandes.html',
   controller: 'demandesCtrl',
   })
.when('/demandes/:id', {
   templateUrl: PartialsPath + '/demande.html',
   controller: 'demandeCtrl',
   })
.when('/missions', {
   templateUrl: PartialsPath + '/missions.html',
   controller: 'missionsCtrl',
   })
.when('/missions/:id', {
    templateUrl: PartialsPath + '/mission.html',
    controller: 'missionCtrl',
    })
.when('/types_mission',{
   templateUrl: PartialsPath + '/types_mission.html',
     controller: 'typesMissionCtrl'
   })
.when('/types_mission/:id',{
   templateUrl: PartialsPath + '/type_mission.html',
   controller: 'typemissionCtrl'
})
.when('/statutsmission',{
   templateUrl: PartialsPath + '/statuts_mission.html',
     controller: 'statutsMissionCtrl'
   })
.when('/statutsmission/:id',{
   templateUrl: PartialsPath + '/statut_mission.html',
   controller: 'statutMissionCtrl'
})
.when('/sourceurs', {
   templateUrl: PartialsPath + '/partenaires.html',
   controller: 'sourceursCtrl',
   })
.when('/sourceurs/:id', {
   templateUrl: PartialsPath + '/partenaire.html',
   controller: 'sourceurCtrl',
})
.when('/contacts/:id', {
   templateUrl: PartialsPath + '/contact.html',
   controller: 'ContactCtrl',
   })
.when('/contacts', {
   templateUrl: PartialsPath + '/contacts.html',
   controller: 'ContactsCtrl',
   })
.when('/statuts/:id', {
   templateUrl: PartialsPath + '/statut.html',
   controller: 'StatutCtrl',
  })
.when('/statuts', {
   templateUrl: PartialsPath + '/statuts.html',
   controller: 'StatutsCtrl',
   })
.when('/dealcomercials/:id', {
   templateUrl: PartialsPath + '/dealcomercial.html',
   controller: 'DealComercialCtrl',
   })
.when('/dealcomercials', {
   templateUrl: PartialsPath + '/dealscomercial.html',
   controller: 'DealsComercialCtrl',
   })
.when('/feedbacks/:id', {
   templateUrl: PartialsPath + '/feedback.html',
   controller: 'FeedBackCtrl',
   })
.when('/feedbacks', {
   templateUrl: PartialsPath + '/feedbacks.html',
   controller: 'FeedBacksCtrl',
   })
.when('/upload_file', {
   templateUrl: PartialsPath + '/ajouter_fichier.html',
   controller: 'ReadfileCtrl',
   })
  //Tests
  //updates
  .when('/UpdateCategorie', {
    templateUrl: TestsPath + '/update/categorie.html',
    controller: 'UpdateCategorieCtrl',
  })
  .when('/UpdateCompetence', {
    templateUrl: TestsPath + '/update/competence.html',
    controller: 'UpdateCompetenceCtrl',
  })
  .when('/UpdateEcole', {
    templateUrl: TestsPath + '/update/ecole.html',
    controller: 'UpdateEcoleCtrl',
  })
  .when('/UpdateEntreprise', {
    templateUrl: TestsPath + '/update/entreprise.html',
    controller: 'UpdateEntrepriseCtrl',
  })
  .when('/UpdateExperience', {
    templateUrl: TestsPath + '/update/experience.html',
    controller: 'UpdateExperienceCtrl',
  })
  .when('/UpdateFormation', {
    templateUrl: TestsPath + '/update/formation.html',
    controller: 'UpdateFormationCtrl',
  })
  .when('/UpdateLangue', {
    templateUrl: TestsPath + '/update/langue.html',
    controller: 'UpdateLangueCtrl',
  })
  .when('/UpdateProjet', {
    templateUrl: TestsPath + '/update/projet.html',
    controller: 'UpdateProjetCtrl',
  })
  .when('/UpdateTag', {
    templateUrl: TestsPath + '/update/tag.html',
    controller: 'UpdateTagCtrl',
  })
  .when('/UpdateTypeFormation', {
    templateUrl: TestsPath + '/update/typeFormation.html',
    controller: 'UpdateTypeFormationCtrl',
  })
  //Insert
  .when('/insert_categorie', {
    templateUrl: TestsPath + '/insert/insert_categorie.html',
    controller: 'InsertCategorieCtrl',
  })
  .when('/insert_competence', {
    templateUrl: TestsPath + '/insert/insert_competence.html',
    controller: 'InsertCompetenceCtrl',
  })
  .when('/upload_Cv', {
    templateUrl: PartialsPath + '/upload_cv.html',
  controller: 'UploadCvCtrl',
  })
  .when('/cvs/:id', {
    templateUrl: PartialsPath + '/update_cv.html',
    controller: 'UpdateCvCtrl',
  })
  .when('/missionsbydemande/:id', {
    templateUrl: PartialsPath + '/missionsbydemande.html',
    controller: 'MissionByDemandeCtrl',
  })
  .when('/candidatbysourceur/:id', {
    templateUrl: PartialsPath + '/candidatbysourceur.html',
    controller: 'CandidatBySourceurCtrl',
  })
  .when('/actions', {
    templateUrl: PartialsPath + '/actions.html',
    controller: 'ActionsCtrl',
  })
  .when('/actions/:id', {
    templateUrl: PartialsPath + '/action.html',
    controller: 'ActionCtrl',
  })
  .when('/typesaction', {
    templateUrl: PartialsPath + '/types_action.html',
    controller: 'typesActionCtrl',
  })
  .when('/typesaction/:id', {
    templateUrl: PartialsPath + '/type_action.html',
    controller: 'typeActionCtrl',
  })
  .when('/contributionsourceurs', {
    templateUrl: PartialsPath + '/contribution_partenaires.html',
    controller: 'ContributionSourceurCtrl',
  })
   .when('/candidatsbymission',{
    templateUrl: PartialsPath + '/candidatsbymission.html',
    controller: 'candidatsbymissionCtrl'
  })
   .when('/shortliste',{
    templateUrl: PartialsPath + '/short_liste.html',
    controller: 'ShortListeCtrl'
  })
  */
  .otherwise({
    redirectTo: '/'
  });
});