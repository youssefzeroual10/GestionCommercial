//Factories
app.factory("retrive_rows", function($resource) {
  return $resource(HostName + "/api/entities");
});
//
app.factory("Services", function($http) {
	
	var NbrCommandeYear = function(){
		return $http.get("/nbrcommandeyear");
	}
	var NbrCommandeMois = function(){
		return $http.get("/nbrcommandemois");
	}
	var bestSalesMonth = function(){
		return $http.get("/bestSalesMonth");
	}
	var bestClient = function(){
		return $http.get("/bestClient");
	}
	var bestFournisseur = function(){
		return $http.get("/bestFournisseur");
	}
	var bestVendeur = function(){
		return $http.get("/bestVendeur");
	}
	  return{ NbrCommandeYear : NbrCommandeYear,
		  NbrCommandeMois : NbrCommandeMois,
		  bestSalesMonth:bestSalesMonth,
		  bestVendeur: bestVendeur,
		  bestClient: bestClient,
		  bestFournisseur: bestFournisseur,}
	});
app.factory("UserLogged", function($resource) {
	  return $resource(HostName + "/getuser");
	});
app.factory("getSortiesInValide", function($resource) {
	  return $resource(HostName + "/sortiesinvalide");
	});
app.factory("getNbrCommandeYear", function($resource) {
	  return $resource(HostName + "/nbrcommandeyear");
	});
app.factory("getPerime", function($resource) {
	  return $resource(HostName + "/perDef");
	});
app.factory("getFournisseurs", function($resource) {
	  return $resource(HostName + "/fournisseurs");
	});
app.factory("getNextAutoIncrement", function($resource) {
	  return $resource(HostName + "/getNextAutoIncrement");
	});
app.factory("getVilles", function($resource) {
	  return $resource(HostName + "/villes");
	});
app.factory("getDateCommandes", function($resource) {
	  return $resource(HostName + "/getdatecommandes");
	});
app.factory("getRoles", function($resource) {
	  return $resource(HostName + "/roles");
	});

app.factory("getQuartiers", function($resource) {
	  return $resource(HostName + "/quartiers");
	});
app.factory("getTypeClients", function($resource) {
	  return $resource(HostName + "/typeclients");
	});
app.factory("getUsers", function($resource) {
	  return $resource(HostName + "/users");
	});
app.factory("getCategories", function($resource) {
  return $resource(HostName + "/categories");
});

app.factory("getEtats", function($resource) {
  return $resource(HostName + "/etats");
});
app.factory("getFournisseurs", function($resource) {
	  return $resource(HostName + "/fournisseurs");
});
app.factory("getTypeActions", function($resource) {
	  return $resource(HostName + "/typeActions");
});
app.factory("getVehicules", function($resource) {
	  return $resource(HostName + "/getVehicules");
});
app.factory("getSousCategories", function($resource) {
	  return $resource(HostName + "/sousCategories");
});

app.factory("getCommandes", function($resource) {
  return $resource(HostName + "/commandes");
});

app.factory("getTaxes", function($resource) {
  return $resource(HostName + "/taxes");
});

app.factory("getArticles", function($resource) {
  return $resource(HostName + "/articles");
});

app.factory("getCompetences", function($resource) {
  return $resource(HostName + "/api/competences");
});

app.factory("getClients", function($resource) {
  return $resource(HostName + "/clients");
});
app.factory("getPromotions", function($resource) {
	  return $resource(HostName + "/articlesnopromo");
	});
app.factory("getCodes", function($resource) {
	  return $resource(HostName + "/codes");
	});
app.factory("getDemandes", function($resource) {
  return $resource(HostName + "/api/demandes");
});
app.factory("getTaxes", function($resource) {
  return $resource(HostName + "/taxes");
});
app.factory("getVilles", function($resource) {
  return $resource(HostName + "/villes");
});
app.factory("getQuartiers", function($resource) {
	  return $resource(HostName + "/quartiers");
	});
app.factory("getDealcomercials", function($resource) {
  return $resource(HostName + "/api/dealcomercials");
});
app.factory("getCompetencesExceptPassedCompetence", ['$resource', '$q', '$http', function($resource, $q, $http) {
  
  var factory = {
    query: function(competence, response){
      $http({
        method : 'GET',
        url : HostName + '/api/competencesexceptpassedcompetences/'+ competence        
      })
      .success(function(data){
        return data;
      });
    }
  };
  return factory; 
}]);

app.factory("getEcoles", function($resource) {
  return $resource(HostName + "/api/ecoles");
});

app.factory("getLangues", function($resource) {
  return $resource(HostName + "/api/langues");
});

app.factory("getProjets", function($resource) {
  return $resource(HostName + "/api/projets");
});

app.factory("getTypesformation", function($resource) {
  return $resource(HostName + "/api/typesformation");
});
app.factory("getTypesmission", function($resource) {
  return $resource(HostName + "/api/typesmission");
});
app.factory("getMissiontags", function($resource) {
  return $resource(HostName + "/api/missiontags");
});
app.factory("getMissioncompetences", function($resource) {
  return $resource(HostName + "/api/missioncompetences");
});
app.factory("getMissiontypeformations", function($resource) {
  return $resource(HostName + "/api/missiontypeformations");
});
app.factory("getFormations", function($resource) {
  return $resource(HostName + "/api/formations");
});
app.factory("getCandidats", function($resource) {
  return $resource(HostName + "/api/candidats");
});
app.factory("getCandidatlangues", function($resource) {
  return $resource(HostName + "/api/candidatlangues");
});
app.factory("getMissionlangues", function($resource) {
  return $resource(HostName + "/api/missionlangues");
});
app.factory("getCandidatcompetences", function($resource) {
  return $resource(HostName + "/api/candidatcompetences");
});
app.factory("getCandidattags", function($resource) {
  return $resource(HostName + "/api/candidattags");
});
app.factory("getContacts", function($resource) {
  return $resource(HostName + "/api/contacts");
});
app.factory("getFeedbacks", function($resource) {
  return $resource(HostName + "/api/feedbacks");
});
app.factory("getStatuts", function($resource) {
  return $resource(HostName + "/api/statuts");
});
app.factory("getStatutsmission", function($resource) {
  return $resource(HostName + "/api/statutsmission");
});
app.factory("getActions", function($resource) {
  return $resource(HostName + "/api/actions");
});
app.factory("getTypesaction", function($resource) {
  return $resource(HostName + "/api/typesaction");
});
app.factory("getCvs", function($resource) {
  return $resource(HostName + "/api/cvs");
});
app.factory("getStatuts", function($resource) {
  return $resource(HostName + "/api/statuts");
});
app.factory("getCvs", function($resource) {
  return $resource(HostName + "/api/cvs");
});
//Services
app.service('cvUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,langue,comment,candidat,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('langue', langue);
    fd.append('comment', comment);
    fd.append('candidat', candidat);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
    .success(function(data){
      console.log(data);
        return data;
    })
    .error(function(data){
          console.log(data);

        });
  }
}]);
//CV Update
app.service('UpdateCv', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,langue,comment,candidat,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('langue', langue);
    fd.append('comment', comment);
    fd.append('candidat', candidat);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.dir(data);
          return data;
        })
        .error(function(){
          console.log(data);

        });
  }
}]);
// Candidat

app.service('photoUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,first_name,last_name,birth_date,address,email,phone,gender,nationality,family_situation,qualification_degree,
                                  qualification_comment,comment,disponibility,sourceur,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('first_name', first_name);
    fd.append('last_name', last_name);
    fd.append('birth_date', birth_date);
    fd.append('address', address);
    fd.append('email', email);
    fd.append('phone', phone);
    fd.append('gender', gender);
    fd.append('nationality', nationality);
    fd.append('family_situation', family_situation);
    fd.append('qualification_degree', qualification_degree);
    fd.append('qualification_comment', qualification_comment);
    fd.append('comment', comment);
    fd.append('disponibility', disponibility);
    fd.append('sourceur', sourceur);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);
        });
  }
}]);

// update  Candidat

app.service('updatecandidat', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,first_name,last_name,birth_date,address,email,phone,gender,nationality,family_situation,qualification_degree,
                                  qualification_comment,comment,disponibility,sourceur,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('first_name', first_name);
    fd.append('last_name', last_name);
    fd.append('birth_date', birth_date);
    fd.append('address', address);
    fd.append('email', email);
    fd.append('phone', phone);
    fd.append('gender', gender);
    fd.append('nationality', nationality);
    fd.append('family_situation', family_situation);
    fd.append('qualification_degree', qualification_degree);
    fd.append('qualification_comment', qualification_comment);
    fd.append('comment', comment);
    fd.append('disponibility', disponibility);
    fd.append('sourceur', sourceur);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);

// CLient

app.service('clientUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,name,address,email,phone,type,comment,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('name', name);
    fd.append('address', address);
    fd.append('email', email);
    fd.append('phone', phone);
    fd.append('type', type);
    fd.append('comment', comment);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
        })
        .error(function(){
          console.log(data);

        });
  }
}]);

// update  Candidat

app.service('updateclient', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,name,address,email,phone,type,comment,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('name', name);
    fd.append('address', address);
    fd.append('email', email);
    fd.append('phone', phone);
    fd.append('type', type);
    fd.append('comment', comment);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(){
        });
  }
}]);
// Demande

app.service('demandeUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,titre,description,date_start,client,contact,statut,cf_reel,cf_potentiel,probabilite,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('titre', titre);
    fd.append('description', description);
    fd.append('date_start', date_start);
    fd.append('client', client);
    fd.append('contact', contact);
    fd.append('statut', statut);
    fd.append('cf_reel', cf_reel);
    fd.append('cf_potentiel', cf_potentiel);
    fd.append('probabilite', probabilite);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);

// update  demande

app.service('demandeUpdate', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,title,description,date_demande,client,contact,statut,cf_reel,cf_potentiel,probabilite,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('title', title);
    fd.append('description', description);
    fd.append('date_demande', date_demande);
    fd.append('client', client);
    fd.append('contact', contact);
    fd.append('statut', statut);
    fd.append('cf_reel', cf_reel);
    fd.append('cf_potentiel', cf_potentiel);
    fd.append('probabilite', probabilite);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);

// cheque

app.service('chequeUpload', ['$http','$route', function ($http,$route) {
  this.uploadFileToUrl = function(cheque,datePaiement,idCommande,montant,uploadUrl){
    var fd = new FormData();
    fd.append('cheque', cheque);
    fd.append('datePaiement', datePaiement);
    fd.append('idCommande', idCommande);
    fd.append('montant', montant);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          $route.reload();

        })
        .error(function(data){
          console.log(data);

        });
  }
}]);
//bon Commande
app.service('bonCommandeUpload', ['$http','$route','$window','$modal' ,function ($http,$route,$window,$modal) {
	  this.uploadFileToUrl = function(bonCommande,montant,dateCommande,idCommande,idFournisseur,uploadUrl){
	    var fd = new FormData();
	    fd.append('bonCommande', bonCommande);
	    fd.append('montant', montant);
	    fd.append('dateCommande', dateCommande);
	    fd.append('idCommande', idCommande);
	    fd.append('idFournisseur', idFournisseur);
	    $http.post(uploadUrl, fd, {
	      transformRequest: angular.identity,
	      headers: {'Content-Type': undefined}
	    })
	    .success(function(data) {
			$window.location.href= '#entrees/'+data.idCommande;
			$scope.formEntree.$submitted = false;
			console.log(data);
			$scope.msg="";
		}).error(function(data) {
			console.log(data);
			$scope.msg = data.message;
		});
	  }
	}]);
//Action
app.service('ActionsUpload', ['$http','$route','$window','$modal' ,function ($http,$route,$window,$modal) {
	  this.uploadFileToUrl = function(facture,description,montant,dateAction,dateAlert,paye,alert,immatriculation,idTypeAction,uploadUrl){
	    var fd = new FormData();
	    fd.append('facture', facture);
	    fd.append('description', description);
	    fd.append('montant', montant);
	    fd.append('dateAction', dateAction);
	    fd.append('dateAlert', dateAlert);
	    fd.append('paye', paye);
	    fd.append('alert', alert);
	    fd.append('immatriculation', immatriculation);
	    fd.append('idTypeAction', idTypeAction);
	    $http.post(uploadUrl, fd, {
	      transformRequest: angular.identity,
	      headers: {'Content-Type': undefined}
	    })
	    .success(function(data) {
			//$window.location.href= '#entrees/'+data.idCommande;
			$scope.formAction.$submitted = false;
			$scope.showUpload=false;
			console.log(data);
			$scope.msg="";
		}).error(function(data) {
			console.log(data);
			$scope.msg = data.message;
		});
	  }
	}]);
//Action Update
app.service('ActionUpload', ['$http','$route','$window','$modal' ,function ($http,$route,$window,$modal) {
	  this.uploadFileToUrl = function(facture,description,montant,dateAction,dateAlert,paye,alert,immatriculation,idTypeAction,idAction,uploadUrl){
	    var fd = new FormData();
	    fd.append('facture', facture);
	    fd.append('description', description);
	    fd.append('montant', montant);
	    fd.append('dateAction', dateAction);
	    fd.append('dateAlert', dateAlert);
	    fd.append('paye', paye);
	    fd.append('alert', alert);
	    fd.append('immatriculation', immatriculation);
	    fd.append('idTypeAction', idTypeAction);
	    fd.append('idAction', idAction);
	    $http.post(uploadUrl, fd, {
	      transformRequest: angular.identity,
	      headers: {'Content-Type': undefined}
	    })
	    .success(function(data) {
			//$window.location.href= '#entrees/'+data.idCommande;
			$scope.formAction.$submitted = false;
			$scope.showUpload=false;
			console.log(data);
			$scope.msg="";
		}).error(function(data) {
			console.log(data);
			$scope.msg = data.message;
		});
	  }
	}]);

// update  sourceur

app.service('sourceurUpdate', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,first_name,last_name,phone,email,address,type,confidance,pricelevel,reliability,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('first_name', first_name);
    fd.append('last_name', last_name);
    fd.append('phone', phone);
    fd.append('email', email);
    fd.append('address', address);
    fd.append('type', type);
    fd.append('confidance', confidance);
    fd.append('pricelevel', pricelevel);
    fd.append('reliability', reliability);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);

// Sourceur

app.service('sourceurUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,name,phone,email,address,type,confidance,pricelevel,reliability,dealcomercial,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('name', name);
    fd.append('phone', phone);
    fd.append('email', email);
    fd.append('address', address);
    fd.append('type', type);
    fd.append('confidance', confidance);
    fd.append('pricelevel', pricelevel);
    fd.append('reliability', reliability);
    fd.append('dealcomercial', dealcomercial);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);

// update  sourceur

app.service('sourceurUpdate', ['$http', function ($http) {
  this.uploadFileToUrl = function(file,id,name,phone,email,address,type,confidance,pricelevel,reliability,dealcomercial,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    fd.append('id', id);
    fd.append('name', name);
    fd.append('phone', phone);
    fd.append('email', email);
    fd.append('address', address);
    fd.append('type', type);
    fd.append('confidance', confidance);
    fd.append('pricelevel', pricelevel);
    fd.append('reliability', reliability);
    fd.append('dealcomercial', dealcomercial);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          return data;
        })
        .error(function(data){
          console.log(data);

        });
  }
}]);
// Read file
app.service('Readfile', ['$http','$route', function ($http,$route) {
  this.uploadFileToUrl = function(file,uploadUrl){
    var fd = new FormData();
    fd.append('file', file);
    $http.post(uploadUrl, fd, {
      transformRequest: angular.identity,
      headers: {'Content-Type': undefined}
    })
        .success(function(data){
          console.log(data);
          $route.reload();
        })
        .error(function(data){
          console.log(data);
         

        });
  }
}]);
