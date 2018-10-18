///////////////////////////////////////////////////////////////////////////////
// Promotions Promotions Promotions Promotions
/////////////////////////////////////////////////////////////////////////////
app.controller('PromotionsCtrl', function($scope, $http, getPromotions, $routeParams) {
	// init params for pagination
	$scope.pagePromotions = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	
	$scope.getAllArticles = function() {
		getPromotions.query(function(data) {
			$scope.articles = data;
		});
	}
	// get paginate taxes
	$scope.chargerPromotions = function() {
		$scope.errorMessage = null;
		$http.get(
				"/articlesallpromo?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pagePromotions = data;
					console.log(data);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})

		;
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerPromotions();
	};

	//Retrive all taxes using "promotions" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/articlesnopromo',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerPromotions();
	}).error(function(data) {
		$scope.promotions = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/promotions',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerPromotions();
			$scope.inserted = {};
		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/promotions/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerPromotions();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

// controller for update
app
		.controller(
				'PromotionCtrl',
				function($scope,getPromotions, $http, $routeParams) {
					$scope.id = $routeParams.id;
					var id = $scope.id;
					$scope.getAllArticles = function() {
						getPromotions.query(function(data) {
							$scope.articles = data;
						});
					}
					// Get
					console.log(id);
					var HostName = 'http://localhost:8681';
					$http(
							{
								method : 'GET',
								url : HostName + '/promotions/' + id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.promotion = data;
								console.log(data);
							})
							.error(
									function(data) {
										$scope.promotion = {};
										// console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/promotions',
										data : $.param($scope.promotion),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
// Taxes Taxes Taxes Taxes Taxes
/////////////////////////////////////////////////////////////////////////////
app.controller('TaxesCtrl', function($scope, $http, getTaxes, $routeParams) {
	// init params for pagination
	$scope.pageTaxes = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate taxes
	$scope.chargerTaxes = function() {
		$scope.errorMessage = null;
		$http.get(
				"/gettaxes?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageTaxes = data;
					console.log($scope.pageQuartiers);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})

		;
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerTaxes();
	};

	// here model and view bindings logic
	$scope.title = "Ajout des Taxes";
	//Retrive all taxes using "taxes" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/taxes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerTaxes();
	}).error(function(data) {
		$scope.taxes = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/taxes',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerTaxes();
		}).error(function(data) {
			console.log(data.message);
			$scope.msg = data;
		});
	}

	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/taxes/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerTaxes();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

// controller for update
app
		.controller(
				'TaxeCtrl',
				function($scope, $http, $routeParams) {
					$scope.id = $routeParams.id;
					var id = $scope.id;
					// Get
					console.log(id);
					var HostName = 'http://localhost:8681';
					$http(
							{
								method : 'GET',
								url : HostName + '/taxes/' + id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.taxe = data;
							})
							.error(
									function(data) {
										$scope.taxe = {};
										// console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/taxes',
										data : $.param($scope.taxe),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
///////////////////////////////////////////////////////////////////////////////
//Etats Etats Etats Etats Etats
/////////////////////////////////////////////////////////////////////////////
app.controller('EtatsCtrl', function($scope, $http, getEtats, $routeParams) {
	// init params for pagination
	$scope.pageEtats = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate taxes
	$scope.chargerEtats = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getetats?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageEtats = data;
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerEtats();
	};
	// here model and view bindings logic
	$scope.title = "Ajout des Etats";
	//Retrive all Etats using "Etats" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/etats',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerEtats();
		})
	.error(function(data) {
		$scope.etats = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/etats',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerEtats();
		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/etats/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerEtats();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

//controller for update
app
		.controller(
				'EtatCtrl',
				function($scope, $http, $routeParams) {
					$scope.id = $routeParams.id;
					var id = $scope.id;
					// Get
					console.log(id);
					var HostName = 'http://localhost:8681';
					$http(
							{
								method : 'GET',
								url : HostName + '/etats/' + id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.etat = data;
							})
							.error(
									function(data) {
										$scope.etat = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/etats',
										data : $.param($scope.etat),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
// /////////////////////////////////////////////////////////////////////////////
// Villes Villes Villes Villes
// ///////////////////////////////////////////////////////////////////////////
app.controller('VillesCtrl', function($scope, getVilles, $http, $routeParams) {
	// init params for pagination
	$scope.pageQuartiers = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate quartiers
	$scope.chargerVilles = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getvilles?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize).success(function(data) {
			$scope.pageVilles = data;
			$scope.pages = new Array(data.totalPages)
		}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerVilles();
	};
	

	// here model and view bindings logic
	$scope.title = "Ajout des des Villes";
	// Retrive all taxes using "taxes" Service
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/villes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		console.log(data);
		$scope.chargerVilles();
		$scope.villes = data;
	}).error(function(data) {
		$scope.villes = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/villes',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerVilles();
			$scope.villes = data;
			$scope.formVille.$submitted=false;
			$scope.inserted = {};

		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {

			$http({
				method : 'DELETE',
				url : HostName + '/villes/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				// ///Chargement des villes
				$scope.chargerVilles();
				// ///Chargement des quartiers
			}).error(function(data) {
				alert(data.message);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});

		}
	}
});

// controller for update
app
		.controller(
				'VilleCtrl',
				function($scope, $http, $routeParams) {
					var HostName = 'http://localhost:8681';
					$scope.id = $routeParams.id;
					var id = $scope.id;
					console.log(id);
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/villes/' + $routeParams.id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.ville = data;
							})
							.error(
									function(data) {
										// $scope.ville = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/villes',
										data : $.param($scope.ville),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								$scope.formVille.$submitted=false;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
// /////////////////////////////////////////////////////////////////////////////
// Quartiers Quartiers Quartiers
// ///////////////////////////////////////////////////////////////////////////
app
		.controller(
				'QuartiersCtrl',
				function($scope, getVilles,getUsers, $http, $routeParams) {
					// init params for pagination
					$scope.pageQuartiers = {};
					$scope.pageSize = 3;
					$scope.pageCourante = 0;
					$scope.pages = {};
					// get paginate quartiers
					$scope.chargerQuartiers = function() {
						$scope.errorMessage = null;
						$http.get(
								"/getquartiers?page=" + $scope.pageCourante
										+ "&size=" + $scope.pageSize).success(
								function(data) {
									$scope.pageQuartiers = data;
									console.log($scope.pageQuartiers);
									$scope.pages = new Array(data.totalPages)
								}).error(function(data) {
							$scope.errorMessage = data.message;
						})

						;
					};
					$scope.goToPage = function(p) {
						$scope.pageCourante = p;
						$scope.chargerQuartiers();
					};
					// load select villes
					$scope.getAllVilles = function() {
						getVilles.query(function(data) {
							$scope.villes = data;
						});
					};
					getUsers.query(function(data) {
						$scope.users = data;
					});
					// here model and view bindings logic
					$scope.title = "Ajout des des Quartiers";
					// Retrive all villes using "villes" Service
					getVilles.query(function(data) {
						$scope.villes = data;
					});
					var HostName = 'http://localhost:8681';
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/quartiers',
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							}).success(function(data) {
						console.log("Loaded successfully!");
						console.log(data);
						$scope.chargerQuartiers();
					}).error(function(data) {
						$scope.quartiers = {};
						console.log(data);
						// $scope.msg =data;
						// $scope.msg = "Failed to laod please contact
						// developer!";
					});
					// insert new record block
					$scope.inserted = {};
					// Call api insert Action
					$scope.onInsert = function() {
						$http(
								{
									method : 'POST',
									url : HostName + '/quartiers',
									data : $.param($scope.inserted),
									headers : {
										'Content-Type' : 'application/x-www-form-urlencoded'
									}
								})
								.success(
										function(data) {
											
											$http(
													{
														method : 'GET',
														url : HostName
																+ '/quartiers',
														headers : {
															'Content-Type' : 'application/x-www-form-urlencoded'
														}
													})
													.success(
															function(data) {
																console
																		.log("Loaded successfully!");
																console
																		.log(data);
																$scope
																		.chargerQuartiers();
																
																$scope.inserted = {};
																$scope.formVille.$submitted=false;
																$scope.formQuartier.$submitted=false;
															})
													.error(function(data) {
														console.log(data);
													});
										}).error(function(data) {
									console.log(data);
									$scope.msg = data;
								});
					}

					// remove selected record block
					$scope.onDelete = function(id) {
						if (confirm("etes vous sur ? ")) {
							$http(
									{
										method : 'DELETE',
										url : HostName + '/quartiers/' + id,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									})
									.success(function(data) {
										$scope.chargerQuartiers();

									})
									.error(
											function(data) {
												// console.log(data);
												// $scope.msg =data;
												$scope.msg = "Failed to remove please contact developer!";
											});
						}
					}
				});

// controller for update
app
		.controller(
				'QuartierCtrl',
				function($scope, getVilles,getUsers, $http, $routeParams) {
					$scope.id = $routeParams.id;
					var id = $scope.id;
					getUsers.query(function(data) {
						$scope.users = data;
					});
					// Retrive all client using "getClients" Service
					getVilles.query(function(data) {
						$scope.villes = data;
					});
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/quartiers/' + id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.quartier = data;
							})
							.error(
									function(data) {
										$scope.quartier = {};
										// console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						var params = "idVille=" + $scope.quartier.ville.idVille
								+ "&idQuartier=" + id 
								+ "&idUser=" + $scope.quartier.user.idUser +
								"&libelle="+ $scope.quartier.libelle;
						console.log(params);
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/quartiers',
										data : params,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});

// /////////////////////////////////////////////////////////////////////////////
// Categories Categories Categories Categories
// ///////////////////////////////////////////////////////////////////////////
app.controller('CategoriesCtrl', function($scope, getCategories, $http,$routeParams) {
	// init params for pagination
	$scope.pageSousCategories = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate SousCategories
	$scope.chargerCategories = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getcategories?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize).success(function(data) {
			$scope.pageCategories = data;
			$scope.pages = new Array(data.totalPages)
		}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerCategories();
	};
	
	// here model and view bindings logic
	$scope.title = "Ajout des des Categories";
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/categories',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		console.log(data);
		$scope.chargerCategories();
		$scope.categories = data;

	}).error(function(data) {
		$scope.Categories = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/categories',
			data : $.param($scope.inserted),
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
		}).success(function(data) {
			$scope.chargerCategories();
			$scope.categories = data;
			$scope.inserted = {};
			$scope.formCategorie.$submitted=false;


		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {

			$http({
				method : 'DELETE',
				url : HostName + '/categories/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				// ///Chargement des Categories
				$scope.chargerCategories();
				// ///Chargement des SousCategories
			}).error(function(data) {
				alert(data.message);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

// controller for update
app
		.controller(
				'CategorieCtrl',
				function($scope, $http, $routeParams) {
					var HostName = 'http://localhost:8681';
					$scope.id = $routeParams.id;
					var id = $scope.id;
					console.log(id);
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/categories/'
										+ $routeParams.id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.categorie = data;
							})
							.error(
									function(data) {
										// $scope.categorie = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/categories',
										data : $.param($scope.categorie),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								$scope.formCategorie.$submitted=false;
								// $scope.msg = "Updated successfully!";

							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
// /////////////////////////////////////////////////////////////////////////////
// SousCategories SousCategories SousCategories
// ///////////////////////////////////////////////////////////////////////////
app.controller('SousCategoriesCtrl', function($scope, getCategories, $http,$routeParams) {
	// init params for pagination
	$scope.pageSousCategories = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate SousCategories
	$scope.chargerSousCategories = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getsousCategories?page=" 
						+ $scope.pageCourante + "&size="
						+ $scope.pageSize)           
			.success(function(data) {
			$scope.pageSousCategories = data;
			$scope.pages = new Array(data.totalPages)
		}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerSousCategories();
	};
	// load select Categories
	$scope.getAllCategories = function() {
		getCategories.query(function(data) {
			$scope.categories = data;
		});
	};
	// here model and view bindings logic
	$scope.title = "Ajout des des SousCategories";
	// Retrive all Categories using "Categories" Service
	getCategories.query(function(data) {
		$scope.categories = data;
	});
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/sousCategories',
		headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	}).success(function(data) {
		console.log("Loaded successfully!");
		console.log(data);
		$scope.chargerSousCategories();
	}).error(function(data) {
		$scope.sousCategories = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/sousCategories',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			console.log($scope.inserted);
			$scope.chargerSousCategories();
			$scope.inserted={};
			$scope.formSousCategorie.$submitted=false;
			
		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/sousCategories/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerSousCategories();

			}).error(function(data) {
				// console.log(data);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

// controller for update
app.controller('SousCategorieCtrl',function($scope, getCategories, $http, $routeParams) {
	$scope.id = $routeParams.id;
	var id = $scope.id;
	// Retrive all client using "getCategories" Service
	getCategories.query(function(data) {
		$scope.categories = data;
	});
	// Get
	$http({
		method : 'GET',
		url : HostName + '/sousCategories/' + id,
		headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	})
	.success(function(data) {
		console.log("Loaded successfully!");
		$scope.sousCategorie = data;
	})
	.error(function(data) {
		$scope.sousCategorie = {};
		// console.log(data);
		// $scope.msg =data;
		//$scope.msg = "Failed to laod please contact developer!";
	});
	// Call edit action
	$scope.onUpdate = function() {
		var params = "idCategorie=" + $scope.sousCategorie.categorie.idCategorie
								+ "&idSousCategorie=" + id + "&libelle="
								+ $scope.sousCategorie.libelle;
		console.log(params);
		if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
				$http({
					method : 'PUT',
					url : HostName + '/sousCategories',
					data : params,
					headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
				})
				.success(function(data) {
					$scope.msg = data;
					$scope.formSousCategorie.$submitted=false;

					// $scope.msg = "Updated successfully!";
					// $scope.domaine = {};
				})
				.error(function(data) {
					console.log(data);
					$scope.msg = data;
					// $scope.msg = "Failed to update please contact
					// developer!";
				});
		}
					}
				});

///////////////////////////////////////////////////////////////////////////////
//Articless Articless Articless
/////////////////////////////////////////////////////////////////////////////
app.controller('ArticlesCtrl', function($modal,$scope,getFournisseurs,getPerime,getSousCategories,getCommandes,getTaxes, $http,$routeParams) {
	
	 
	// init params for pagination
	$scope.pageArticles = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate Articles
	$scope.chargerArticles = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getArticles?page=" 
						+ $scope.pageCourante + "&size="
						+ $scope.pageSize)           
			.success(function(data) {
			$scope.pageArticles = data;
			$scope.pages = new Array(data.totalPages)
		}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerArticles();
	};
	// faire appell aux articles qui vont etre perime
	getPerime.query(function(data) {
		console.log(data);
	});
	// load select SousCategories
		getSousCategories.query(function(data) {
			$scope.sousCategories = data;
		});
	// load select fournisseurs
		getFournisseurs.query(function(data) {
			$scope.fournisseurs = data;
		});
	// load select commandes
		getCommandes.query(function(data) {
			$scope.commandes = data;
		});
	// load select taxes
		getTaxes.query(function(data) {
			$scope.taxes = data;
		});
	// here model and view bindings logic
	$scope.title = "Ajout des des Articless";

	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/articles',
		headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerArticles();

	}).error(function(data) {
		$scope.articles = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});


	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/articles/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerArticles();

			}).error(function(data) {
				// console.log(data);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});
///////////////////////////////////////////////////////////////////////////////
//ArticleForm ArticleForm	ArticleForm ArticleForm ArticleForm
/////////////////////////////////////////////////////////////////////////////
app.controller('ArticleFormCtrl', function($window,$modal,$scope,getFournisseurs,getPerime,getSousCategories,getCommandes,getTaxes,getTypeClients ,getQuartiers,getUsers, $http,$routeParams) {
	$scope.loadSousCategories = function() {
		getSousCategories.query(function(data) {
			$scope.sousCategories = data;
		});
	};
	$scope.loadTaxes = function() {
		getTaxes.query(function(data) {
			$scope.taxes = data;
		});
	};
	$scope.loadCommandes = function() {
		getCommandes.query(function(data) {
			$scope.commandes = data;
			console.log(data);
		});
	};
	$scope.loadFournisseurs = function() {
		getFournisseurs.query(function(data) {
			$scope.fournisseurs = data;
		});
	};
	//modal
	 $scope.showModalSousCategorie = function() {
		 	var HostName = 'http://localhost:8681';
	        $scope.opts = {
	        backdrop: true,
	        backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	        templateUrl : HostName+'/app/partials/modalsouscategories.html',
	        controller : ModalInstanceCtrl,
	        resolve: {} // empty storage
	          };
	          
	        
	        $scope.opts.resolve.item = function() {
	            return angular.copy({name:$scope.name}); // pass name to Dialog
	        }
	        
	          var modalInstance = $modal.open($scope.opts);
	          
	          modalInstance.result.then(function(){
	            //on ok button press 
	          },function(){
	            //on cancel button press
	            console.log("Modal Closed");
	          });
	      };  
	
	//end modal
	//modal
	 $scope.showModalFournisseurs = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modalfournisseurs.html',
	        controller : ModalInstanceCtrl,
 	        resolve: {} // empty storage
	    };
        $scope.opts.resolve.item = function() {
        	return angular.copy({name:$scope.name}); // pass name to Dialog
        }
	 	        
        var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 	
	 //end modal      
	//modal
	 $scope.showModalCommandes = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modalcommandes.html',
	        controller : ModalInstanceCtrl,
 	        resolve: {} // empty storage
	    };
        $scope.opts.resolve.item = function() {
        	return angular.copy({name:$scope.name}); // pass name to Dialog
        }
	 	        
        var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal
		//modal
	 $scope.showModalTaxes = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modaltaxes.html',
	        controller : ModalInstanceCtrl,
 	        resolve: {} // empty storage
	    };
        $scope.opts.resolve.item = function() {
        	return angular.copy({name:$scope.name}); // pass name to Dialog
        }
	 	        
        var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal
	$http.get("/getcountarticle")
		.success(function(data) {
			$scope.countArticle=data;
		}).error(function(data) {
			console.log(data);
		});	
	// insert new record block
	$scope.inserted = {};
	$scope.article = {};
	// Call api insert Action
	$scope.onInsert = function() {
		var dateExpedition = moment($scope.inserted.dateExpedition).format('YYYY-MM-DD');
		var params ="designation="+$scope.inserted.designation+
					"&fournisseur="+$scope.inserted.fournisseur+
					"&sousCategorie="+$scope.inserted.sousCategorie+
					"&Commande="+$scope.inserted.Commande+
					"&prixAchat="+$scope.inserted.prixAchat+
					"&dateExpedition="+dateExpedition+
					"&quantite="+$scope.inserted.quantite+
					"&seuilAlert="+$scope.inserted.seuilAlert;

		var date = moment().format("YYYY-MM-DD");
		var mois = moment().add(1, 'months').format("YYYY-MM-DD"); 
			if($scope.inserted.seuilAlert > $scope.inserted.quantite ){
				$scope.msg ="la quantité est inferieure au seuil d'alert ";
			}
			else if(dateExpedition <= mois){
				$scope.msg ="vous devez mettre une date d'expiration conforme";
			}
			else if($scope.inserted.seuilAlert > $scope.inserted.quantite && dateExpedition <= mois ){
				$scope.msg ="la quantité est inferieure au seuil d'alert et la date d'expiration n'est pas conforme ";
			}
			else{
				console.log(params);
				$http({
					method : 'POST',
					url : HostName + '/articles',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
					})
					.success(function(data) {
						console.log($scope.inserted);
						$scope.inserted={};
						$scope.article=data;
						console.log($scope);
						$window.location.href= '#article';
					}).error(function(data) {
						console.log(data);
						$scope.msg = data;
					});
			}
	
		}
	});
//controller for update
app.controller('ArticleCtrl',function($scope,getFournisseurs,getSousCategories,getCommandes,getTaxes, $http, $routeParams) {
	$scope.id = $routeParams.id;
	var id = $scope.id;
 	var HostName = 'http://localhost:8681';

	// load select SousCategories
	getSousCategories.query(function(data) {
		$scope.sousCategories = data;
	});
// load select fournisseurs
	getFournisseurs.query(function(data) {
		$scope.fournisseurs = data;
	});
// load select commandes
	getCommandes.query(function(data) {
		$scope.commandes = data;
	});
// load select taxes
	getTaxes.query(function(data) {
		$scope.taxes = data;
	});

	// Get
	$http({
		method : 'GET',
		url : HostName + '/article/' + id,
		headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	})
	.success(function(data) {
		console.log("Loaded successfully!");
		$scope.article = data;
	})
	.error(function(data) {
		$scope.article = {};
		// console.log(data);
		// $scope.msg =data;
		//$scope.msg = "Failed to laod please contact developer!";
	});
	// Call edit action 
	$scope.onUpdate = function() {
		var params = "designation=" + $scope.article.designation+
					 "&fournisseur=" + $scope.article.fournisseur.idFournisseur+
					 "&sousCategorie="+ $scope.article.sousCategorie.idSousCategorie+
					 
					 "&seuilAlert="+ $scope.article.seuilAlert+
					 "&idArticle="+id
		console.log(params);
		if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
				$http({
					method : 'PUT',
					url : HostName + '/articles',
					data : params,
					headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
				})
				.success(function(data) {
					console.log(data);
					$scope.msg = data;
					// $scope.msg = "Updated successfully!";
					// $scope.domaine = {};
				})
				.error(function(data) {
					console.log(data);
					$scope.msg = data;
					// $scope.msg = "Failed to update please contact
					// developer!";
				});
		}
					}
	});
//controller for commandes clien
app.controller('PrixArticlesCtrl',function($scope,getArticles,$http, $routeParams) {
	// load select articles
	getArticles.query(function(data) {
		$scope.articles = data;
	});	
	$scope.getArticle = function() {
		console.log($scope.inserted.article);
		$http.get("/prixarticles?idArticle="+$scope.inserted.article)
			.success(function(data) {
				$scope.prices = data;
				console.log(data);
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
	};
	
	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
		var params = "idArticle=" + $scope.inserted.article+
		"&libelle=" + $scope.inserted.libelle+
		"&prixVente=" + $scope.inserted.prixVente					
		;
		console.log(params);
		$http({
			method : 'POST',
			url : HostName + '/prix',
			data : params,
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
		}).success(function(data) {		
			$scope.inserted.libelle="";
			$scope.inserted.prixVente="";
			$scope.getArticle();
			$scope.formPrice.$submitted = false;
		}).error(function(data) {
			console.log(data);
		});
	}
});
///////////////////////////////////////////////////////////////////////////////
//Entrees Entrees Entrees 
/////////////////////////////////////////////////////////////////////////////
app.controller('EntreesCtrl', function($window,$scope,getArticles, $http,$routeParams) {
	$scope.id = $routeParams.id;
	var id = $scope.id;
	// load select articles
	getArticles.query(function(data) {
		$scope.articles = data;
	});
	$scope.entrees = [];
								
		$scope.addNew = function(entree){
			$scope.entrees.push({
				
                
			});
	    };
	    	$scope.addEntree = function(){	
	    		angular.forEach($scope.entrees, function(entree) {
	    			var dateExpiration = moment(entree.dateExpedition).format('YYYY-MM-DD');
    				var params = 
					 "dateExpedition="+ dateExpiration+
					 "&quantite="+ entree.quantite+
					 "&prixAchat="+ entree.prixAchat+
					 "&article="+ entree.article+
					 "&commande="+id ;
    				if(angular.isUndefined(entree.article)){
    					  $scope.msg="vous devez choisir un article";
    				  }
    				else{
    					$http({
			    			method : 'PUT',
			    			url : HostName + '/entrer',
			    			data : params,
			    			headers : {
			    				'Content-Type' : 'application/x-www-form-urlencoded'
			    			}
			    		}).success(function(data) {
			    			console.log(data);
			    			$window.location.href= '#/articles'
			    			
			    		}).error(function(data) {
			    			console.log(data);
			    			console.log($scope.entrees);
			    			$scope.msg = data;
			    		});
    				}
					 
    				
    			});
	    		
	    		
	    	};
	    		$scope.remove = function(){
	    			var newDataList=[];
	    			$scope.selectedAll = false;
	    			angular.forEach($scope.entrees, function(selected){
	    				if(!selected.selected){
	    					newDataList.push(selected);
	    				}
	    			}); 
	    			$scope.entrees = newDataList;
	    		};
	    		
	    		$scope.checkAll = function () {
	    			if ($scope.selectedAll) {
	    				$scope.selectedAll = true;
	    			} else {
	    				$scope.selectedAll = false;
	    			}
	    			angular.forEach($scope.entrees, function(entree) {
	    				entree.selected = $scope.selectedAll;
	    			});
	    		};     
}); 
///////////////////////////////////////////////////////////////////////////////
//Sorties Sorties Sorties
/////////////////////////////////////////////////////////////////////////////
app.controller('SortiesCtrl', function($window,$modal,getSortiesInValide,$scope,getArticles, $http,$routeParams) {
	$scope.id = $routeParams.id;
	var id = $scope.id;
	$scope.sortie = {};
	$scope.msg="";
	// load select articles
	getArticles.query(function(data) {
		$scope.articles = data;
	});
	$scope.getPrices = function(){
			$http.get("/prixarticles?idArticle="+$scope.inserted.article)
			.success(function(data) {
				$scope.prices = data;
			}).error(function(data) {
			});
	}
	$scope.getArticle= function(){
		$http.get("/article/"+$scope.inserted.article)
		.success(function(data) {
			$scope.article = data;
		}).error(function(data) {
		});
	}
	$scope.getArticleEdit= function(){
		$http.get("/article/"+$scope.item.article.idArticle)
		.success(function(data) {
			$scope.article = data;
		}).error(function(data) {
		});
	}
	$scope.getPrix = function(){
		$http.get("/prixarticles?idArticle="+$scope.item.article.idArticle)
		.success(function(data) {
			$scope.prices = data;
			console.log(data);
		}).error(function(data) {
		});
}
	//end modal
	// insert new record block
	$scope.inserted = {"quantite":"","prixVente":null,"article":null,"idCommande":0};
	// Call api insert Action
	$scope.onInsert = function() {
	  var params = 
		 "&quantite="+ $scope.inserted.quantite+
		 "&prixVente="+ $scope.inserted.prixVente+
		 "&article="+ $scope.inserted.article+
		 "&idCommande="+ id
		 ;		
	  if($scope.inserted.quantite <0 ){
		  $scope.msg="la quantite doit etre supperieur a zero";
	  }
	  if($scope.inserted.prixVente == null){
		  $scope.msg="vous devez choisir le prix du vente"
	  }
	  if($scope.inserted.article == null){
		  $scope.msg="vous devez choisir un article"
	  }
	  if($scope.inserted.quantite >0 && $scope.inserted.prixVente != null && $scope.inserted.article != null){
		  console.log(params);
	  		$http({
	  			method : 'POST',
	  			url : HostName + '/sortir',
	  			data : params,
	  			headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
	  		}).success(function(data) {
	  			$scope.inserted = {};
	  			$scope.msg="";
				$scope.formSortie.$submitted = false;

	  			
	  		}).error(function(data) {
	  			$scope.msg=data.message;
	  			console.log(data);
	  		});
	  }
	 
	  	}
		// Call edit action
		$scope.onUpdate = function() {
			var params = "idArticle=" + $scope.item.article.idArticle+
			"&idMouvement=" + $scope.item.idMouvement+
			"&prixVente=" + $scope.item.prixVente+
			"&quantite=" + $scope.item.quantite;
			console.log(params);
			if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
				
				$http(
					{
						method : 'PUT',
						url : HostName + '/mouvements',
						data : params,
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded'
						}
					}).success(function(data) {
						console.log(data);
						$scope.msg = data;
					}).error(function(data) {
						console.log(data);
						$scope.msg = data;
						// $scope.msg = "Failed to update please contact
						// developer!";
					});
			}
		}
	  //modal
		 $scope.showModalAddSortie = function() {
			 
			 	var HostName = 'http://localhost:8681';
		        $scope.opts = {
		        backdrop: true,
		        backdropClick: true,
		        dialogFade: false,
		        keyboard: true,
		        templateUrl : HostName+'/app/partials/modaladdsortie.html',
		        controller : ModalInstanceCtrl,
		        resolve: {} // empty storage
		          };
		        $scope.opts.resolve.item = function() {
		            return angular.copy({name:$scope.name}); // pass name to Dialog
		        }
		        var modalInstance = $modal.open($scope.opts);
		          modalInstance.result.then(function(){
		        	  getSortiesInValide.query(function(data) {
		  		  		$scope.sorties = data;
		  		  	 });
		            //on ok button press 
		          },function(){
		            //on cancel button press
		            console.log("Modal Closed");
		            getSortiesInValide.query(function(data) {
				  		$scope.sorties = data;
				  	 });
		          });
		      };
		    //modal
			$scope.showModalEdit = function(idMouvement) {
				var HostName = 'http://localhost:8681';
				 $scope.getSortie = function(idMouvement) {
					// Get
					 
						//.success(function(data) {
							//console.log(data);
							$scope.sortie = $http.get(HostName + '/mouvements/'+ idMouvement);
							console.log($scope.sortie);
							return $scope.sortie;
						//}).error(function(data) {
							//console.log(data);
						//});
					 //return 'fuck you';
				 }
			 	
				$scope.opts = {
					backdrop: true,
				    backdropClick: true,
			        dialogFade: false,
			        keyboard: true,
			        templateUrl : HostName+'/app/partials/modaladdsortieEdit.html',
			        controller : ModalInstanceEditCtrl,
			        resolve: {
			        	sortie: function () {
			        		//console.log($scope.getSortie(idMouvement));
			        		//console.log(idMouvement);
			                 sortie=$scope.getSortie(idMouvement);
			                 return sortie;
			              }
			        	 
			        } 
			     };
				 $scope.opts.resolve.item = function() {
					 return angular.copy({name:$scope.name}); // pass name to Dialog
				 }
				 var modalInstance = $modal.open($scope.opts);
				    modalInstance.result.then(function(){
				       getSortiesInValide.query(function(data) {
				    	   $scope.sorties = data;
				  		});
				  //on ok button press 
				     },function(){
				     //on cancel button press
				         console.log("Modal Closed");
				         getSortiesInValide.query(function(data) {
					  		$scope.sorties = data;
					  	 });
				      });
			};  
	    	$scope.addSortie = function(){	
	    		angular.forEach($scope.sorties, function(sortie) {
  				var params = 
					 "&idMouvement="+ sortie.idMouvement+
					 "&idCommande="+id
					 $http({
			    			method : 'PUT',
			    			url : HostName + '/sortir',
			    			data : params,
			    			headers : {
			    				'Content-Type' : 'application/x-www-form-urlencoded'
			    			}
			    		}).success(function(data) {
			    			console.log(data);
			    			
			    		}).error(function(data) {
			    			console.log(data);
			    		});
  				
  			});
	    		$window.location.href= '#paiements/'+$routeParams.id;
	    	};
	    		$scope.remove = function(){
	    			var newDataList=[];
	    			$scope.selectedAll = false;
	    			angular.forEach($scope.sorties, function(selected){
	    				if(selected.selected){
	    					newDataList.push(selected);
	    					console.log(selected.idMouvement);
	    					$http({
	    						method : 'DELETE',
	    						url : HostName + '/Mouvements/' + selected.idMouvement,
	    						headers : {
	    							'Content-Type' : 'application/x-www-form-urlencoded'
	    						}
	    					}).success(function(data) {
	    						getSortiesInValide.query(function(data) {
	    					  		$scope.sorties = data;
	    					  	 });
	    				
	    					}).error(function(data) {
	    						consolelog(data);	    					});

	    				}
	    			}); 
	    			$scope.sorties = newDataList;
	    		};
	    		
	    		$scope.checkAll = function () {
	    			if ($scope.selectedAll) {
	    				$scope.selectedAll = true;
	    			} else {
	    				$scope.selectedAll = false;
	    			}
	    			angular.forEach($scope.sorties, function(sortie) {
	    				sortie.selected = $scope.selectedAll;
	    			});
	    		};     
}); 


///////////////////////////////////////////////////////////////////////////////
//Clients Clients	Clients Clients Clients Clients Clients Clients
/////////////////////////////////////////////////////////////////////////////
app.controller('ClientsCtrl', function($scope, getQuartiers,getUsers,getClients, $http,$routeParams) {
	getQuartiers.query(function(data) {
		$scope.quartiers = data;
	});
	getUsers.query(function(data) {
		$scope.users = data;
	});
	$http.get(
	"/getcountclient")
	.success(function(data) {
		$scope.countClient=data;
	}).error(function(data) {
		console.log(data);
	});	
	$scope.getPdf = function() {
		$http.get(HostName+'/clients.pdf',{responseType:'arraybuffer'})
		.success(function(data) {
			var file = new Blob([data],{type:'application/pdf'});
			var fileURL =URL.createObjectURL(file);
			window.open(fileURL,'_blank','')
		})
	};
	// init params for pagination
	$scope.pageClients = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate Clients
	$scope.chargerClients = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getclients?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize)
			.success(function(data) {
				$scope.pageClients = data;
				$scope.pages = new Array(data.totalPages);
			console.log(data);
			}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerClients();
	};
	
	// here model and view bindings logic
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/clients',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		$scope.chargerClients();
	}).error(function(data) {
		$scope.clients = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			console.log(id);
			$http({
				method : 'DELETE',
				url : HostName + '/clients/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				// ///Chargement des Clients
				$scope.chargerClients();
		
			}).error(function(data) {
				alert(data.message);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
	$scope.getPdf = function() {
		$http.get(HostName+'/clients.pdf',{responseType:'arraybuffer'})
		.success(function(data) {
			var file = new Blob([data],{type:'application/pdf'});
			var fileURL =URL.createObjectURL(file);
			window.open(fileURL,'_blank','')
		})
	};
});

//controller for update
app
		.controller(
				'ClientCtrl',
				function($scope,getTypeClients ,getQuartiers,getUsers, $http, $routeParams) {
					$http.get(
					"/getcountclient")
					.success(function(data) {
						$scope.countClient=data;
					}).error(function(data) {
						console.log(data);
					});	
					$scope.getQuartier = function() {
						
						$http.get(
								"/getquartier?id=" + $scope.inserted.user )
							.success(function(data) {
								$scope.quartiers = data;
							console.log(data);
							}).error(function(data) {
							$scope.errorMessage = data.message;
						});
					};	
					getQuartiers.query(function(data) {
						$scope.quartiers = data;
					});
					getUsers.query(function(data) {
						$scope.users = data;
					});
					getTypeClients.query(function(data) {
						$scope.typeClients = data;
					});
					var HostName = 'http://localhost:8681';
					$scope.id = $routeParams.id;
					var id = $scope.id;
					console.log(id);
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/clients/'
										+ $routeParams.id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.client = data;
							})
							.error(
									function(data) {
										// $scope.categorie = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});
					

					// Call edit action
					$scope.onUpdate = function() {
						var params = "idTypeClient=" + $scope.client.typeClient.idTypeClient+
						"&idQuartier=" + $scope.client.quartier.idQuartier+
						"&idUser=" + $scope.client.user.idUser+
						 "&cin=" + id + 
						"&nom="+ $scope.client.nom+
						"&adresse="+ $scope.client.adresse+
						"&telephone="+ $scope.client.telephone					
						;
						
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							console.log(params);
							$http(
									{
										method : 'PUT',
										url : HostName + '/clients',
										data : params,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";

							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});

///////////////////////////////////////////////////////////////////////////////
//ClientForm ClientForm	ClientForm ClientForm ClientForm
/////////////////////////////////////////////////////////////////////////////
app.controller('ClientFormCtrl', function($modal,$scope,getRoles,getTypeClients ,getQuartiers,getUsers, $http,$routeParams) {
	$http.get(
	"/getcountclient")
	.success(function(data) {
		$scope.countClient=data;
	}).error(function(data) {
		console.log(data);
	});	
	getRoles.query(function(data) {
		$scope.roles = data;
	});
	
		
	$scope.getQuartier = function() {
		
		$http.get(
				"/getquartier?id=" + $scope.inserted.user )
			.success(function(data) {
				$scope.quartiers = data;
			console.log(data);
			}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	
	getUsers.query(function(data) {
		$scope.users = data;
	});
	getTypeClients.query(function(data) {
		$scope.typeClients = data;
	});
	
	$scope.getAllUsers = function() {
		getUsers.query(function(data) {
			$scope.users = data;
		});
	}
	$scope.getAllTypesClient = function() {
		getTypeClients.query(function(data) {
			$scope.typeClients = data;
		});
	}
	
	//modal user
	 $scope.showModalUser = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modaluser.html',
	        controller : ModalInstanceCtrl,
	        resolve: {} // empty storage
	    };
      $scope.opts.resolve.item = function() {
      	return angular.copy({name:$scope.name}); // pass name to Dialog
      }
	 	        
      var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal user 
	//modal user quartier
	 $scope.showModalQuartier = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modalquartier.html',
	        controller : ModalInstanceCtrl,
	        resolve: {} // empty storage
	    };
      $scope.opts.resolve.item = function() {
      	return angular.copy({name:$scope.name}); // pass name to Dialog
      }
	 	        
      var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal Quartier 
	//modal TypeClient
	 $scope.showModalTypeClient = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modaltypeclient.html',
	        controller : ModalInstanceCtrl,
	        resolve: {} // empty storage
	    };
      $scope.opts.resolve.item = function() {
      	return angular.copy({name:$scope.name}); // pass name to Dialog
      }
	 	        
      var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal Type Client

	var HostName = 'http://localhost:8681';
	$scope.msg1="";
	$scope.msg2="";
	$scope.msg3="";

	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
	/*	if($scope.inserted.user==null && $scope.inserted.quartier== null && $scope.inserted.typeClient==null)
			{	$scope.msg="";
			$scope.msg=" vous devez choisir le chauffeur et la quartier et le type client";}
		if($scope.inserted.user==null && $scope.inserted.quartier== null)
			{$scope.msg=""; $scope.msg=" vous devez choisir le chauffeur et la quartier"}
		if($scope.inserted.user==null )
			{$scope.msg=" vous devez choisir le chauffeur"}*/
		var params = "idTypeClient=" + $scope.inserted.typeClient+
		"&idQuartier=" + $scope.inserted.quartier+
		"&idUser=" + $scope.inserted.user+
		 "&cin=" + $scope.inserted.cin + 
		"&nom="+ $scope.inserted.nom+
		"&adresse="+ $scope.inserted.adresse+
		"&telephone="+ $scope.inserted.telephone;
		console.log(params);
			$http({
				method : 'POST',
				url : HostName + '/clients',
				data : params,
				headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
			}).success(function(data) {
				$scope.inserted = {};
				$scope.msg1="";
				$scope.msg2="";
				$scope.msg3="";
				$scope.formClient.$submitted=false;
				
			}).error(function(data) {
				console.log(data);
				$scope.msg1=data.message;
			});
		
		
		

		
	}
});
///////////////////////////////////////////////////////////////////////////////
//TypeClients TypeClients TypeClients TypeClients
/////////////////////////////////////////////////////////////////////////////
app.controller('TypeClientsCtrl', function($scope, $http, $routeParams) {
	//count client
	$http.get(
	"/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			
	});	
	// init params for pagination
	$scope.pageTypeClients = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate taxes
	$scope.chargerTypeClient = function() {
		$scope.errorMessage = null;
		$http.get(
				"/gettypeclients?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageTypeClients = data;
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerTypeClient();
	};
	// here model and view bindings logic
	//Retrive all Etats using "Etats" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/typeclients',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerTypeClient();
		})
	.error(function(data) {
		$scope.etats = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/typeclients',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerTypeClient();
			$scope.inserted = {};
			$scope.formTypeClient.$submitted=false;
		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}
	
	
	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/typeclients/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerTypeClient();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

//controller for update
app
		.controller(
				'TypeClientCtrl',
				function($scope, $http, $routeParams) {
					$http.get(
						"/getcountclient")
						.success(function(data) {
							$scope.countClient=data;
						}).error(function(data) {
							console.log(data);
					});	
					$scope.id = $routeParams.id;
					var id = $scope.id;
					// Get
					console.log(id);
					var HostName = 'http://localhost:8681';
					$http(
							{
								method : 'GET',
								url : HostName + '/typeclients/' + id,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log("Loaded successfully!");
								$scope.typeClient = data;
							})
							.error(
									function(data) {
										$scope.etat = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {

						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/typeclients',
										data : $.param($scope.typeClient),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
///////////////////////////////////////////////////////////////////////////////
//Clients Clients	Clients Clients Clients Clients Clients Clients
/////////////////////////////////////////////////////////////////////////////
app.controller('ClientsCreditCtrl', function($scope, getQuartiers,getUsers,getClients, $http,$routeParams) {
	$http.get(
	"/getcountclient")
	.success(function(data) {
		$scope.countClient=data;
	}).error(function(data) {
		console.log(data);
	});	

	// init params for pagination
	$scope.pageClients = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.co=true;

	// get paginate Clients
	$scope.chargerClients = function() {
		$scope.errorMessage = null;
		$http.get(
				"/clientscredit?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize)
			.success(function(data) {
				$scope.pageClients = data;
				$scope.pages = new Array(data.totalPages);
			console.log(data);
			}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerClients();
	};
	$scope.chargerClients();
	//find la commande by reference
	$scope.onSearch = function() {
		console.log($scope.idClient);
		if($scope.idClient != null && $scope.idClient != "" ){
			$http({
				method : 'GET',
				url : HostName + '/getClienteById?idCommande='+$scope.idClient,
				headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
				}).success(function(data) {
					$scope.client=data;
					$scope.co=false;
				}).error(function(data) {
					console.log(data);
				});
		}
		if($scope.idClient == null || $scope.idClient == ""){
			$scope.co=true;
			$scope.chargerClients();
		}
		
	}

});


///////////////////////////////////////////////////////////////////////////////
//ClientsBalaye ClientsBalaye ClientsBalaye ClientsBalayeClientsBalaye ClientsBalaye
/////////////////////////////////////////////////////////////////////////////
app.controller('ClientsBalayeCtrl', function($scope,getDateCommandes,getUsers,getClients, $http,$routeParams) {
	getUsers.query(function(data) {
		$scope.users = data;
	});
	$http.get(
			"/getcountclient")
			.success(function(data) {
				$scope.countClient=data;
			}).error(function(data) {
				console.log(data);
	});	
	getDateCommandes.query(function(data) {
		$scope.dates = data;

	});
	$scope.loadQuartier = function() {
		   var id = $scope.find.search;
		   console.log(id);
		   $http.get(
					"/getquartier?id=" + id )
				.success(function(data) {
					$scope.quartiers = data;
				console.log(data);
				}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
	$scope.msg="";
	$scope.find={};
	$scope.Search = function() {
		//if($scope.find.search !=null  && $scope.find.quartier!= null && $scope.find.date!=null)
			//{
				var user = $scope.find.search;
				var quartier = $scope.find.quartier;
				var date = $scope.find.date;
				var params = "?idQuartier=" + quartier+ "&idUser=" + user + "&dateCommande=" + date;
				console.log(params);
				$http.get("/getclientsbalaye?idQuartier=" + quartier
														+ "&idUser=" + user + 
														"&dateCommande=" + date)
						.success(function(data) {
							$scope.clients=data;
							$scope.msg="";
						}).error(function(data) {
							console.log(data);
					});
			//}else{
				//$scope.msg="vous devez remplir les chmaps necessaire";
				//console.log("hi");
			//}

	}
	// init params for pagination
	$scope.pageClients = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// here model and view bindings logic
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/clients',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		$scope.clients = data;
	}).error(function(data) {
		$scope.clients = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
});
///////////////////////////////////////////////////////////////////////////////
//ClientsBalaye ClientsBalaye ClientsBalaye ClientsBalayeClientsBalaye ClientsBalaye
/////////////////////////////////////////////////////////////////////////////
app.controller('ClientsNonBalayeCtrl', function($scope,getDateCommandes,getUsers,getClients, $http,$routeParams) {
	getUsers.query(function(data) {
		$scope.users = data;
	});
	$http.get(
			"/getcountclient")
			.success(function(data) {
				$scope.countClient=data;
			}).error(function(data) {
				console.log(data);
	});	
	getDateCommandes.query(function(data) {
		$scope.dates = data;

	});
	$scope.loadQuartier = function() {
		   var id = $scope.find.search;
		   console.log(id);
		   $http({
				method : 'GET',
				url : HostName + '/getquartiers/'+id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.quartiers = data;
				console.log(data);
			}).error(function(data) {
				console.log(data);
			});
		}
	$scope.msg="";
	$scope.find={};
	$scope.Search = function() {
		if($scope.find.search!=null && $scope.find.quartier!=null && $scope.find.date!=null)
		{
		   $scope.msg="";
		   var user = $scope.find.search;
		   var quartier = $scope.find.quartier;
		   var date = $scope.find.date;
		   var params = "?idQuartier=" + quartier
										+ "&idUser=" + user + 
										"&dateCommande=" + date;
			$http.get(
					"/getclientsnonbalaye?idQuartier=" + quartier
												+ "&idUser=" + user + 
												"&dateCommande=" + date)
					.success(function(data) {
						$scope.clients=data;
						$scope.msg="";
					}).error(function(data) {
						console.log(data);
			});	
		}else{
			$scope.msg="vous devez remplir les chmaps necessaire";
		}
	}
	// init params for pagination
	$scope.pageClients = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// here model and view bindings logic
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/clients',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		$scope.clients = data;
	}).error(function(data) {
		$scope.clients = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
});

//controller for commandes clien
app.controller('CommandesClientCtrl',function($scope ,$http, $routeParams) {
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
	var HostName = 'http://localhost:8681';
	var id = $routeParams.idClient;
	$scope.pageCommandes = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	$http.get("/commandesbyclient?idClient="+id+"&size=" + $routeParams.size
			+ "&page=" +$routeParams.page)
			.success(
					function(data) {
						$scope.pageCommandes = data;
						console.log(data);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
						$scope.errorMessage = data.message;
					});
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/commandesbyclient?idClient="+id+"&size=" + $routeParams.size
				+ "&page=" +$scope.pageCourante)
				.success(function(data) {
					$scope.pageCommandes = data;
					console.log(data);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
	};
	
});
//controller for commandes client credit
app.controller('CommandesClientCreditCtrl',function($scope ,$http, $routeParams) {
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
	var HostName = 'http://localhost:8681';
	var id = $routeParams.idClient;
	$scope.pageCommandes = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	$http.get("/commandesbyclientcredit?idClient="+id+"&size=" + $routeParams.size
			+ "&page=" +$routeParams.page)
			.success(
					function(data) {
						$scope.pageCommandes = data;
						console.log(data);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
						$scope.errorMessage = data.message;
					});
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/commandesbyclientcredit?idClient="+id+"&size=" + $routeParams.size
				+ "&page=" +$scope.pageCourante)
				.success(function(data) {
					$scope.pageCommandes = data;
					console.log(data);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
	};
	
});
//controller for commandes user credit
app.controller('CommandesUserCreditCtrl',function($scope ,$http, $routeParams) {
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
	var HostName = 'http://localhost:8681';
	var id = $routeParams.IdUser;
	$scope.pageCommandes = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	$http.get("/commandesbyusercredit?idClient="+id+"&size=" + $routeParams.size
			+ "&page=" +$routeParams.page)
			.success(
					function(data) {
						$scope.pageCommandes = data;
						console.log(data);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
						$scope.errorMessage = data.message;
					});
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/commandesbyusercredit?idClient="+id+"&size=" + $routeParams.size
				+ "&page=" +$scope.pageCourante)
				.success(function(data) {
					$scope.pageCommandes = data;
					console.log(data);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
	};
	
});

///////////////////////////////////////////////////////////////////////////////
//UserForm UserForm	UserForm UserForm UserForm
/////////////////////////////////////////////////////////////////////////////
app.controller('UserFormCtrl', function($modal,$scope,getRoles ,$http,$routeParams) {
	$http.get(
	"/getcountuser")
	.success(function(data) {
		$scope.countUser=data;
	}).error(function(data) {
		console.log(data);
	});	

	getRoles.query(function(data) {
		$scope.roles = data;
	});
	$scope.getRoles = function() {
		getRoles.query(function(data) {
			$scope.roles = data;
		});
	}
	//modal
	 $scope.showModalRoles = function() {
	 	var HostName = 'http://localhost:8681';
	 	$scope.opts = {
	    	backdrop: true,
	 	    backdropClick: true,
	        dialogFade: false,
	        keyboard: true,
	 	    templateUrl : HostName+'/app/partials/modalroles.html',
	        controller : ModalInstanceCtrl,
	        resolve: {} // empty storage
	    };
       $scope.opts.resolve.item = function() {
       	return angular.copy({name:$scope.name}); // pass name to Dialog
       }
	 	        
       var modalInstance = $modal.open($scope.opts);
	 	     modalInstance.result.then(function(){
	 	            //on ok button press 
	 	      },function(){
	 	            //on cancel button press
	 	            console.log("Modal Closed");
	 	          });
	 };  
	 //end modal
	var HostName = 'http://localhost:8681';

	// insert new record block
	$scope.inserted = {};
	// Call api insert Action
	$scope.onInsert = function() {
		var params = 
			 "idUser="+ $scope.inserted.idUser+
			 "&password="+ $scope.inserted.password+
			 "&nom="+ $scope.inserted.nom+
			 "&prenom="+ $scope.inserted.prenom+
			 "&email="+ $scope.inserted.email+
			 "&adresse="+ $scope.inserted.adresse+
			 "&telephone="+ $scope.inserted.telephone+
			 "&dateEmbauche="+ $scope.inserted.dateEmbauche+
			 "&role="+ $scope.inserted.role;
			 /*"&activation="+$scope.inserted.actived*/
			console.log(params);

			 $http({
	    			method : 'POST',
	    			url : HostName + '/users',
	    			data : params,
	    			headers : {
	    				'Content-Type' : 'application/x-www-form-urlencoded'
	    			}
	    		}).success(function(data) {
	    			
	    			$scope.inserted = {};
					$scope.formUser.$submitted=false;
	    		}).error(function(data) {
	    			console.log(data);
	    		});
	}
});
///////////////////////////////////////////////////////////////////////////////
//users users users users users users users users users 
/////////////////////////////////////////////////////////////////////////////
app.controller('UsersCtrl', function($scope,$http,$routeParams) {
	$http.get(
	"/getcountuser")
	.success(function(data) {
		$scope.countUser=data;
	}).error(function(data) {
		console.log(data);
	});	

	// init params for pagination
	$scope.pageUsers = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate Clients
	$scope.chargerUsers = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getusers?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize)
			.success(function(data) {
				$scope.pageUsers = data;
				$scope.pages = new Array(data.totalPages);
			console.log(data);
			}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerUsers();
	};
	
	// here model and view bindings logic
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/users',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		$scope.chargerUsers();
	}).error(function(data) {
		$scope.users = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			console.log(id);
			$http({
				method : 'DELETE',
				url : HostName + '/users/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				// ///Chargement des Clients
				$scope.chargerUsers();
		
			}).error(function(data) {
				alert(data.message);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
	$scope.getPdf = function() {
		$http.get(HostName+'/users.pdf',{responseType:'arraybuffer'})
		.success(function(data) {
			var file = new Blob([data],{type:'application/pdf'});
			var fileURL =URL.createObjectURL(file);
			window.open(fileURL,'_blank','')
		})
	};
})
///////////////////////////////////////////////////////////////////////////////
//roles roles roles roles roles roles roles roles roles roles roles 
/////////////////////////////////////////////////////////////////////////////
app.controller('RolesCtrl', function($scope,$http,$routeParams) {
	$http.get(
	"/getcountuser")
	.success(function(data) {
		$scope.countUser=data;
	}).error(function(data) {
		console.log(data);
	});	

	// init params for pagination
	$scope.pageRoles = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate Clients
	$scope.chargerRoles = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getroles?page=" + $scope.pageCourante + "&size="
						+ $scope.pageSize)
			.success(function(data) {
				$scope.pageRoles = data;
				$scope.pages = new Array(data.totalPages);
			console.log(data);
			}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerRoles();
	};
	
	// here model and view bindings logic
	var HostName = 'http://localhost:8681';
	// Get
	$http({
		method : 'GET',
		url : HostName + '/roles',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		$scope.chargerRoles();
	}).error(function(data) {
		$scope.roles = {};
		console.log(data);
		// $scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/roles',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerRoles();
			$scope.inserted = {};
			$scope.formRole.$submitted=false;

		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}
	
	// remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			console.log(id);
			$http({
				method : 'DELETE',
				url : HostName + '/roles/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				// ///Chargement des Clients
				$scope.chargerRoles();
		
			}).error(function(data) {
				console.log(data);
				// $scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});



//controller for update
app.controller('RoleCtrl',function($scope, $http, $routeParams) {
	$http.get("/getcountuser")
		.success(function(data) {
			$scope.countUser=data;
		})
		.error(function(data) {
		});	
	$scope.id = $routeParams.role;
	var id = $scope.id;
	// Get
	console.log(id);
	var HostName = 'http://localhost:8681';
		$http(
				{
			method : 'GET',
			url : HostName + '/roles/' + id,
			headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
			}
	})
	.success(function(data) {
		console.log("Loaded successfully!");
		$scope.role = data;
	})
	.error(function(data) {
		console.log(data);
		
	});
	
	// Call edit action
	$scope.onUpdate = function() {
	
		if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
			$http(
					{
			method : 'PUT',
			url : HostName + '/roles',
			data : $.param($scope.role),
			headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
			}
					})
					.success(function(data) {
						console.log(data);
					})
					.error(function(data) {
						console.log(data);
					});
		}
		}
	});

//controller for update
app
		.controller(
				'UserCtrl',
				function($scope,getRoles , $http, $routeParams) {
					$http.get(
					"/getcountuser")
					.success(function(data) {
						$scope.countUser=data;
					}).error(function(data) {
						console.log(data);
					});	

					getRoles.query(function(data) {
						$scope.roles = data;
					});
					var HostName = 'http://localhost:8681';
					$scope.id = $routeParams.IdUser;
					var id = $scope.id;
					console.log(id);
					// Get
					$http(
							{
								method : 'GET',
								url : HostName + '/users/'+ $routeParams.IdUser,
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded'
								}
							})
							.success(function(data) {
								console.log(data);
								$scope.user = data;
							})
							.error(
									function(data) {
										// $scope.categorie = {};
										console.log(data);
										// $scope.msg =data;
										$scope.msg = "Failed to laod please contact developer!";
									});

					// Call edit action
					$scope.onUpdate = function() {
						var params = 
							 "idUser="+ $scope.user.idUser+
							 "&nom="+ $scope.user.nom+
							 "&prenom="+ $scope.user.prenom+
							 "&email="+ $scope.user.email+
							 "&adresse="+ $scope.user.adresse+
							 "&telephone="+ $scope.user.telephone+
							 "&dateEmbauche="+ $scope.user.dateEmbauche+
							 "&role="+ $scope.user.role
							 /*"&activation="+$scope.user.actived*/
						if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
							$http(
									{
										method : 'PUT',
										url : HostName + '/users',
										data : params,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								$scope.formUser.$submitted=false;
								// $scope.msg = "Updated successfully!";

							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
				});
///////////////////////////////////////////////////////////////////////////////
// Mouvements MouvementsMouvementsMouvements Mouvements MouvementsMouvements
/////////////////////////////////////////////////////////////////////////////
app.controller('MouvementsCtrl', function($scope,getArticles,$http,$routeParams) {
	var id= $routeParams.id;
	console.log($routeParams);
	$http.get(
	"/getcountarticle")
	.success(function(data) {
		$scope.countArticle=data;
	}).error(function(data) {
		console.log(data);
	});
	getArticles.query(function(data) {
		$scope.articles = data;
	});
	$scope.pageEntrees = {};
	$scope.pageSorties = {};
	$scope.pageDefectueuse = {};
	$scope.pagePerime = {};
	$scope.pageSize = 10;
	$scope.pageCouranteEntree = 0;
	$scope.pageCouranteSortie = 0;
	$scope.pageCouranteCadeau = 0;
	$scope.pageCouranteDef = 0;
	$scope.pagesEntree = {};
	$scope.pagesSortie = {};
	$scope.pagesCadeau = {};
	$scope.pagesDef = {};

	
	$scope.errorMessage = null;
	//entrees
	$http.get("/entrees?id="+id+"&size=" + $scope.pageSize
							+ "&page=" +$scope.pageCouranteEntree)
			.success(
			function(data) {
				$scope.pageEntrees = data;
				$scope.pagesEntree = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		$scope.goToPageEntree = function(p) {
		$scope.pageCouranteEntree = p;
		$http.get("/entrees?id="+id+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCouranteEntree)
			.success(
			function(data) {
				$scope.pageEntrees = data;
				$scope.pagesEntree = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		};
	//sorties
		$http.get("/sorties?id="+id+"&size=" +$scope.pageSize
				+ "&page=" +$scope.pageCouranteSortie)
			.success(
			function(data) {
				$scope.pageSorties = data;
				$scope.pagesSortie = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
			$scope.goToPageSortie = function(p) {
			$scope.pageCouranteSortie = p;
			$http.get("/sorties?id="+id+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCouranteSortie)
			.success(
			function(data) {
				$scope.pageSorties = data;
				$scope.pagesSortie = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
			};	
			$http.get("/defectueuses?id="+id+"&size=" + $scope.pageSize
					+ "&page=" +$scope.pageCouranteDef)
				.success(
				function(data) {
					$scope.pageDefectueuses = data;
					$scope.pagesDef = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
	//defectueuse
			$scope.Def = function() {
				$http.get("/defectueuses?id="+$scope.inserted.article+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCouranteDef)
					.success(
					function(data) {
						$scope.pageDefectueuses = data;
						$scope.pagesDef = new Array(data.totalPages)
					}).error(function(data) {
						$scope.errorMessage = data.message;
					});
			}
		$scope.goDef = function() {
			$http.get("/defectueuses?id="+$scope.inserted.article+"&size=" + $scope.pageSize
					+ "&page=" +$scope.pageCouranteDef)
				.success(
				function(data) {
					$scope.pageDefectueuses = data;
					$scope.pagesDef = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		}
		$scope.goToPageDef2 = function(p) {
			$scope.pageCouranteDef = p;
			$http.get("/defectueuses?id="+id+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCouranteDef)
				.success(function(data) {
					$scope.pageDefectueuses = data;
					$scope.pagesDef = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		};
		$scope.goToPageDef = function(p) {
			$scope.pageCouranteDef = p;
			$http.get("/defectueuses?id="+$scope.inserted.article+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCouranteDef)
				.success(function(data) {
					$scope.pageDefectueuses = data;
					$scope.pagesDef = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		};
		//perimé
		//defectueuse
		$scope.getDefectueuse = function() {
		$http.get("/defectueuses?id="+$scope.inserted.article+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCouranteDef)
			.success(
			function(data) {
				$scope.pageDefectueuses = data;
				console.log(data);
				$scope.pagesDef = new Array(data.totalPages)
			}).error(function(data) {
				console.log(data);

			});
		}
		//cadeau cadeau
		$http.get("/cadeau?id="+id+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCouranteCadeau)
			.success(
			function(data) {
				$scope.pageCadeau = data;
				console.log(data);
				$scope.pagesCadeau = new Array(data.totalPages)
			}).error(function(data) {
				console.log(data);

			});
		$scope.goToPageCad = function(p) {
			$scope.pageCouranteCadeau = p;
			$http.get("/cadeau?id="+id+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCouranteCadeau)
				.success(function(data) {
					$scope.pageCadeau = data;
					$scope.pagesCadeau = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		};
		$scope.goToPagePerime = function(p) {
			$scope.pageCourante = p;
			$http.get("/perime?idArticle="+id+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCourante)
				.success(function(data) {
					$scope.pagePerime = data;
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		};	
		// insert new record block
		$scope.inserted = {};
		// Call api insert Action
		$scope.onInsert = function() {
			var params = 
				 "article="+$scope.inserted.article+
				 "&libelle="+ $scope.inserted.libelle+
				 "&quantite="+ $scope.inserted.quantite;
			console.log(params);
			$http({
				method : 'POST',
				url : HostName + '/defectueuses',
				data : params,
				headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
			}).success(function(data) {
				$scope.Def();
				$scope.inserted = {};
				
				
			}).error(function(data) {
				console.log(data);
			});
		}
});

///////////////////////////////////////////////////////////////////////////////
//ArticlePerime ArticlePerime ArticlePerimeArticlePerimeArticlePerimeArticlePerime
/////////////////////////////////////////////////////////////////////////////
app.controller('ArticlePerimeCtrl', function($scope,$http,$routeParams) {
	var id= $routeParams.id;
	console.log($routeParams);
	$http.get(
	"/getcountarticle")
	.success(function(data) {
		$scope.countArticle=data;
	}).error(function(data) {
		console.log(data);
	});

	$scope.pagePerime = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	var date = moment().format("YYYY-MM-DD");
	var mois = moment().add(1, 'months').format("YYYY-MM-DD"); 
	console.log(mois);
	//perimé
	$http.get("/perime?date="+mois+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCourante)
		.success(function(data) {
			$scope.pagePerime = data;
			console.log(data);
			$scope.pages = new Array(data.totalPages)
		})
		.error(function(data) {
				console.log(data);
			});
	console.log("date="+mois+"&size=" + $scope.pageSize+ "&page=" +$scope.pageCourante);

		$scope.goToPage = function(p) {
			$scope.pageCourante = p;
			$http.get("/perime?date="+mois+"&size=" + $scope.pageSize
						+ "&page=" +$scope.pageCourante)
				.success(function(data) {
					$scope.pagePerime = data;
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
					$scope.errorMessage = data.message;
				});
		};	
		
});
///////////////////////////////////////////////////////////////////////////////
//Taxes Taxes Taxes Taxes Taxes
/////////////////////////////////////////////////////////////////////////////
app.controller('FournisseursCtrl', function($window,$scope, $http, $routeParams) {
	// init params for pagination
	$scope.pageFournisseurs = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate fornisseurs
	$scope.chargerFournisseurs = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getfournisseurs?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageFournisseurs = data;
					console.log($scope.pageFournisseurs);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})
		;
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerFournisseurs();
	};
	//Retrive all taxes using "taxes" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/fournisseurs',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerFournisseurs();
	}).error(function(data) {
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/fournisseurs',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerFournisseurs();
			$scope.inserted ={};
			$scope.formFournisseur.$submitted=false;
		}).error(function(data) {
			
		});
	}

	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/fournisseurs/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerFournisseurs();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});

//controller for update
app.controller('FournisseurCtrl',function($scope, $http, $routeParams) {
	$scope.id = $routeParams.id;
	var id = $scope.id;
	// Get
	var HostName = 'http://localhost:8681';
	$http({
		method : 'GET',
		url : HostName + '/fournisseurs/' + id,
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
		})
			.success(function(data) {
				console.log("Loaded successfully!");
				$scope.fournisseur = data;
			})
			.error(function(data) {
				$scope.fournisseur = {};
				// console.log(data);
				// $scope.msg =data;
				$scope.msg = "Failed to laod please contact developer!";
			});

		// Call edit action
			$scope.onUpdate = function() {
				if (confirm("etes vous sur? vous voullez enregistrer cet enregistrement !")) {
					$http(
									{
										method : 'PUT',
										url : HostName + '/fournisseurs',
										data : $.param($scope.fournisseur),
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										}
									}).success(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Updated successfully!";
								// $scope.domaine = {};
							}).error(function(data) {
								console.log(data);
								$scope.msg = data;
								// $scope.msg = "Failed to update please contact
								// developer!";
							});
						}
					}
});
//controller for commandes clien
app.controller('ArticlesByFournisseurCtrl',function($scope ,$http, $routeParams) {
	
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
		var HostName = 'http://localhost:8681';
		var id = $routeParams.idFournisseur;
		$scope.pageArticles = {};
		$scope.pageSize = 3;
		$scope.pageCourante = 0;
		$scope.pages = {};
		$scope.errorMessage = null;
		$http.get("/articlesbyfournisseur?idFournisseur="+id+"&size=" + $routeParams.size
											+ "&page=" +$routeParams.page)
			.success(function(data) {
				$scope.pageArticles = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/articlesbyfournisseur?idFournisseur="+id+"&size=" + $routeParams.size
								+ "&page=" +$routeParams.page)
			.success(function(data) {
				$scope.pageArticles = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
	};				
});


//controller for articles  by fournisseur
app.controller('ArticlesByFournisseursCtrl',function($scope ,getFournisseurs,$http, $routeParams) {
	getFournisseurs.query(function(data) {
		$scope.fournisseurs = data;
	});
	var HostName = 'http://localhost:8681';
	var id = $routeParams.idFournisseur;
	$scope.pageArticles = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	
	$scope.getfournisseur = function() {
		console.log($scope.fournisseur);
		$http.get("/articlesbyfournisseur?idFournisseur="+$scope.fournisseur+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCourante)
			.success(function(data) {
				$scope.pageArticles = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/articlesbyfournisseur?idFournisseur="+$scope.fournisseur+"&size=" + $scope.pageSize
							+ "&page=" +$scope.pageCourante)
			.success(function(data) {
				$scope.pageArticles = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		};				

}
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
		
});

//controller for commandes  by fournisseur
app.controller('CommandesByFournisseursCtrl',function($scope ,getFournisseurs,$http, $routeParams) {
	getFournisseurs.query(function(data) {
		$scope.fournisseurs = data;
	});
	var HostName = 'http://localhost:8681';
	var id = $routeParams.idFournisseur;
	$scope.pageCommandes = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.errorMessage = null;
	
	$scope.getfournisseur = function() {
		console.log($scope.fournisseur);
		$http.get("/commandesbyfournisseur?idFournisseur="+$scope.fournisseur+"&size=" + $scope.pageSize
				+ "&page=" +$scope.pageCourante)
			.success(function(data) {
				$scope.pageCommandes = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$http.get("/commandesbyfournisseur?idFournisseur="+$scope.fournisseur+"&size=" + $scope.pageSize
							+ "&page=" +$scope.pageCourante)
			.success(function(data) {
				$scope.pageCommandes = data;
				console.log(data);
				$scope.pages = new Array(data.totalPages)
			}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		};				

}
	$http.get("/getcountclient")
		.success(function(data) {
			$scope.countClient=data;
		}).error(function(data) {
			console.log(data);
		});
		
});
//controller for commandes  by Paiement
app.controller('PaiementsCtrl', ['$scope','$http','$routeParams','$route', 'chequeUpload',function($scope,$http,$routeParams,$route,chequeUpload){
	
	$scope.commande = $routeParams.id;
	$scope.paiements=[{libelle:"credit"},{libelle:"espece"},{libelle:"cheque"}];
	$scope.inserted = {};
	//get Commande
	$http.get("/getcommande?idCommande="+$routeParams.id)
		.success(function(data) {
			$scope.commande = data;
		}).error(function(data) {
			console.log(data);
		});
	//get cadeau
	$http.get("/getcadeau?idCommande="+$routeParams.id)
		.success(function(data) {
			$scope.promotions = data;
			console.log(data);
		}).error(function(data) {
			console.log(data);
		});
	//get paiement
	$http.get("/getpaiements?idCommande="+$routeParams.id)
	.success(function(data) {
		$scope.finance = data;
		console.log(data);
	}).error(function(data) {
		console.log(data);
	});
	$scope.getPaiement = function() {
		console.log($scope.commande.paiements);
		if($scope.commande.paiements == 'credit'){
			$scope.credit = true;
			$scope.cheque = false;
			$scope.espece = false;
			$scope.msg=null;
		}
		if($scope.commande.paiements == 'cheque'){
			$scope.credit = false;
			$scope.cheque = true;
			$scope.espece = false;
			$scope.msg=null;
		}
		if($scope.commande.paiements == 'espece'){
			$scope.credit = false;
			$scope.cheque = false;
			$scope.espece = true;
			$scope.msg=null;
			

		}
	}

	$scope.onInsert = function() {
		if($scope.commande.paiements == 'credit' && $scope.commande.avance == null ){
			var params ="idCommande="+$scope.commande.idCommande+
						"&montant="+$scope.commande.montant;
			console.log(params);
				$http({
					method : 'POST',
					url : HostName + '/credits',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data);
					$scope.msg = data;
				});
			
		}
		if($scope.commande.paiements == 'credit' && $scope.commande.avance != null){
			var params ="idCommande="+$scope.commande.idCommande+
						"&montant="+$scope.commande.montant+
						"&avance="+$scope.commande.avance
						;
			console.log(params);
				$http({
					method : 'POST',
					url : HostName + '/credit',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data);
					$scope.msg = data;
				});
			
		}
		if($scope.commande.paiements == 'cheque'){
			if($scope.commande.cheque==null)
			{
				$scope.msg="choisir un cheque";
			}else{
				var cheque = $scope.commande.cheque;
				console.log($scope);
				var idCommande = $scope.commande.idCommande;
				var montant = $scope.commande.montant;
				var uploadUrl = HostName + "/cheque";
				chequeUpload.uploadFileToUrl(cheque,idCommande,montant,uploadUrl);
				$route.reload();
			}
			
			    
			
		}
		if($scope.commande.paiements == 'espece'){
				var params ="idCommande="+$scope.commande.idCommande+
				"&montant="+$scope.commande.montant
				;
				$http({
					method : 'POST',
					url : HostName + '/espece',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data.message);
					$scope.msg = data;
				});
			}
		
	}
	
}]);
//controller for commandes paiement
app.controller('PaiementsCommandeCtrl',function($scope ,$http, $routeParams) {
	
	var HostName = 'http://localhost:8681';
	var id = $routeParams.idCommande;
	$http.get("/getpaiements?idCommande="+id)
		.success(function(data) {
			$scope.paiements = data;
			console.log(data);
		}).error(function(data) {
			console.log(data);
		});
});

//controller for commandes 
app.controller('CommandesCtrl',function($scope ,$http, $routeParams) {
	// init params for pagination
	$scope.pageCommandes = {};
	$scope.pageSize = 3;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate taxes
	$scope.chargerCommandes = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getcommandes?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageCommandes = data;
					console.log($scope.pageCommandes);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})

		;
	};
	
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerCommandes();
	};
	//Get
	$http({
		method : 'GET',
		url : HostName + '/commandes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerCommandes();
	}).error(function(data) {
		$scope.commandes = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	
});
//controller for commandes achats
app.controller('CommandesDetailAchatCtrl',function($scope ,$http, $routeParams) {
	// init params for pagination
	$scope.pageCommandes = {};
	$scope.pageSize = 1;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.chargerCommandes = function() {
		$scope.pageCourante=0;
		$http.get(
				"/commandesnow?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageCommandes = data;
					console.log($scope.pageCommandes);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})

		;
	};
	
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		var  jour = $scope.search.day;
		var  mois = $scope.search.month;
		var  annee = $scope.search.year;
		if((jour !=undefined &&  jour !="") && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesjour?jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesdm?mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if(($scope.search.day==undefined || $scope.search.day=="" ) && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesnow?page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="" )){
			
			$http.get(
					"/commandesdmy?annee="+annee+"&mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour==undefined || jour=="") && (mois==undefined || mois=="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesyear?annee="+annee+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans une année
		if((jour==undefined || jour=="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesmonth?annee="+annee+"&mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans cette année
		if((jour==undefined || jour=="")&& (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesmois?mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages);
						
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		
	};
	
	//Get
	$http({
		method : 'GET',
		url : HostName + '/commandes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerCommandes();
	}).error(function(data) {
		$scope.commandes = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	$scope.search={};
	// on search
	$scope.onSearch = function() {
		var  jour = $scope.search.day;
		var  mois = $scope.search.month;
		var  annee = $scope.search.year;
		$scope.pageCourante = 0;	
		if((jour !=undefined &&  jour !="") && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesjour?jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesdm?mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if(($scope.search.day==undefined || $scope.search.day=="" ) && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesnow?page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="" )){
			
			$http.get(
					"/commandesdmy?annee="+annee+"&mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour==undefined || jour=="") && (mois==undefined || mois=="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesyear?annee="+annee+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans une année
		if((jour==undefined || jour=="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesmonth?annee="+annee+"&mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans cette année
		if((jour==undefined || jour=="")&& (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesmois?mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//$scope.search={};
	}
});
//controller for commandes Vente
app.controller('CommandesDetailVenteCtrl',function($scope ,$http, $routeParams) {
	// init params for pagination
	$scope.pageCommandes = {};
	$scope.pageSize = 1;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.chargerCommandes = function() {
		$scope.pageCourante=0;
		$http.get(
				"/commandesnowvente?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageCommandes = data;
					console.log($scope.pageCommandes);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		})

		;
	};
	
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		var  jour = $scope.search.day;
		var  mois = $scope.search.month;
		var  annee = $scope.search.year;
		if((jour !=undefined &&  jour !="") && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesjourvente?jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesdmvente?mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if(($scope.search.day==undefined || $scope.search.day=="" ) && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesnowvente?page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="" )){
			
			$http.get(
					"/commandesdmyvente?annee="+annee+"&mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour==undefined || jour=="") && (mois==undefined || mois=="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesyearvente?annee="+annee+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans une année
		if((jour==undefined || jour=="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesmonthvente?annee="+annee+"&mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans cette année
		if((jour==undefined || jour=="")&& (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesmoisvente?mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages);
						
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		
	};
	
	//Get
	$http({
		method : 'GET',
		url : HostName + '/commandesventes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerCommandes();
	}).error(function(data) {
		$scope.commandes = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	$scope.search={};
	// on search
	$scope.onSearch = function() {
		var  jour = $scope.search.day;
		var  mois = $scope.search.month;
		var  annee = $scope.search.year;
		$scope.pageCourante = 0;	
		if((jour !=undefined &&  jour !="") && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesjourvente?jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesdmvente?mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if(($scope.search.day==undefined || $scope.search.day=="" ) && ($scope.search.month==undefined || $scope.search.month=="") && ($scope.search.year==undefined || $scope.search.year=="")){
			
			$http.get(
					"/commandesnowvente?page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour!=undefined && jour!="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="" )){
			
			$http.get(
					"/commandesdmyvente?annee="+annee+"&mois="+mois+"&jour="+jour+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		if((jour==undefined || jour=="") && (mois==undefined || mois=="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesyearvente?annee="+annee+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans une année
		if((jour==undefined || jour=="") && (mois!=undefined && mois!="") && (annee!=undefined && annee!="")){
			
			$http.get(
					"/commandesmonthvente?annee="+annee+"&mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//commandes par mois dans cette année
		if((jour==undefined || jour=="")&& (mois!=undefined && mois!="") && (annee==undefined || annee=="")){
			
			$http.get(
					"/commandesmoisvente?mois="+mois+"&page=" + $scope.pageCourante
							+ "&size=" + $scope.pageSize).success(
					function(data) {
						$scope.pageCommandes = data;
						console.log($scope.pageCommandes);
						$scope.pages = new Array(data.totalPages)
					}).error(function(data) {
				$scope.errorMessage = data.message;
			});
		}
		//$scope.search={};
	}
});
// commande credit
//controller for commandes  credit
app.controller('CommandesCreditCtrl',function($scope ,$http, $routeParams) {
	// init params for pagination
	$scope.pageCommandes = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	$scope.commande=[];
	$scope.co=true;
	// get paginate taxes
	$scope.chargerCommandes = function() {
		$scope.errorMessage = null;
		$http.get(
				"/commandescredit?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageCommandes = data;
					console.log($scope.pageCommandes);
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	
	$scope.goToPage = function(p) {
		$scope.pageCommande = p;
		$scope.chargerCommandes();
	};
	$scope.chargerCommandes();
	//find la commande by reference
	$scope.onSearch = function() {
		console.log($scope.idCommande);
		if($scope.idCommande != null && $scope.idCommande != "" ){
			$http({
				method : 'GET',
				url : HostName + '/getcommande?idCommande='+$scope.idCommande,
				headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
				}).success(function(data) {
					$scope.commande=data;
					$scope.co=false;
					$scope.msg="";
				}).error(function(data) {
					$scope.co=true;
					$scope.msg=data.message;
				});
		}
		if($scope.idCommande == null || $scope.idCommande == ""){
			$scope.co=true;
			$scope.chargerCommandes();
		}
		
	}
});
//controller for commandes  by Paiement
app.controller('PaiementsCreditCtrl', ['$scope','$http','$routeParams','$route', 'chequeUpload',function($scope,$http,$routeParams,$route,chequeUpload){
	
	$scope.commande = $routeParams.id;
	$scope.paiements=[{libelle:"credit"},{libelle:"espece"},{libelle:"cheque"}];
	$scope.inserted = {};
	$scope.co=false;

	//find la commande by reference
	$scope.onSearch = function() {
		console.log($scope.idCommande);
		if($scope.idCommande != null && $scope.idCommande != "" ){
			$http({
				method : 'GET',
				url : HostName + '/getcommande?idCommande='+$scope.idCommande,
				headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
				}).success(function(data) {
					$scope.commande=data;
					console.log(data);
					$scope.msg=""
					$scope.co=true;
				}).error(function(data) {
					console.log(data);
					$scope.co=false;
					$scope.msg=data.message;
				});
		}
		if($scope.idCommande == null || $scope.idCommande == ""){
			$scope.co=false;
		}
		
	}
/*	//get Commande
	$http.get("/getcommande?idCommande="+$routeParams.id)
		.success(function(data) {
			$scope.commande = data;
		}).error(function(data) {
			console.log(data);
		});
	//get paiement
	$http.get("/getpaiements?idCommande="+$routeParams.id)
	.success(function(data) {
		$scope.finance = data;
		console.log(data);
	}).error(function(data) {
		console.log(data);
	});*/
	$scope.getPaiement = function() {
		console.log($scope.commande.paiements);
		if($scope.commande.paiements == 'credit'){
			$scope.credit = true;
			$scope.cheque = false;
			$scope.espece = false;
			$scope.msg=null;
		}
		if($scope.commande.paiements == 'cheque'){
			$scope.credit = false;
			$scope.cheque = true;
			$scope.espece = false;
			$scope.msg=null;
		}
		if($scope.commande.paiements == 'espece'){
			$scope.credit = false;
			$scope.cheque = false;
			$scope.espece = true;
			$scope.msg=null;
			

		}
	}

	$scope.onInsert = function() {
		if($scope.commande.paiements == 'credit' && $scope.commande.avance == null ){
			var params ="idCommande="+$scope.commande.idCommande+
						"&montant="+$scope.commande.montant;
			console.log(params);
				$http({
					method : 'POST',
					url : HostName + '/credits',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data);
					$scope.msg = data;
				});
			
		}
		if($scope.commande.paiements == 'credit' && $scope.commande.avance != null){
			var params ="idCommande="+$scope.commande.idCommande+
						"&montant="+$scope.commande.montant+
						"&avance="+$scope.commande.avance
						;
			console.log(params);
				$http({
					method : 'POST',
					url : HostName + '/credit',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data);
					$scope.msg = data;
				});
			
		}
		if($scope.commande.paiements == 'cheque'){
			if($scope.commande.cheque==null)
			{
				$scope.msg="choisir un cheque";
			}else{
				var cheque = $scope.commande.cheque;
				console.log($scope);
				var idCommande = $scope.commande.idCommande;
				var montant = $scope.commande.montant;
				var uploadUrl = HostName + "/cheque";
				chequeUpload.uploadFileToUrl(cheque,idCommande,montant,uploadUrl);
				$route.reload();
			}
			
			    
			
		}
		if($scope.commande.paiements == 'espece'){
				var params ="idCommande="+$scope.commande.idCommande+
				"&montant="+$scope.commande.montant
				;
				$http({
					method : 'POST',
					url : HostName + '/espece',
					data : params,
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data) {
					$route.reload();
				}).error(function(data) {
					console.log(data.message);
					$scope.msg = data;
				});
			}
		
	}
	
}]);
///////////////////////////////////////////////////////////////////////////////
//commande entree modal commande entree modal
/////////////////////////////////////////////////////////////////////////////
app.controller('CommandeEntreeModalCtrl', function($window,$modal,$scope,getFournisseurs, $http,$routeParams) {
	// load select fournisseurs
		getFournisseurs.query(function(data) {
			$scope.fournisseurs = data;
		});
		$scope.msg ="";	
	var HostName = 'http://localhost:8681';
	$scope.onInsert = function() {
		var montant = parseInt($scope.inserted.montant);
		var dateCommande = moment($scope.inserted.dateCommande).format('YYYY-MM-DD');
		var params ="idCommande="+$scope.inserted.idCommande+
					"&montant="+montant+
					"&dateCommande="+dateCommande+
					"&idFournisseur="+$scope.inserted.fournisseur
		console.log(params);
		if(angular.isNumber(montant) || montant<0) {
			  $scope.msg="le montant doit etre un nombre et supperieur a zero";
		  }
		  /*if(angular.isDate($scope.inserted.dateCommande)){
			  $scope.msg="vous devez choisir le prix du vente";
		  }*/
		  if(angular.isUndefined($scope.inserted.fournisseur)){
			  $scope.msg="vous devez choisir un fournisseur";
		  }
		  console.log(parseInt($scope.inserted.montant));
		  if(angular.isNumber(montant) && montant >0 && !angular.isUndefined($scope.inserted.fournisseur)){
			  $http({
					method : 'POST',
					url : HostName + '/commandeentree',
					data : params,
					headers : {
								'Content-Type' : 'application/x-www-form-urlencoded'
							}
					}).success(function(data) {
						$scope.formCommande.$submitted=false;
						$scope.inserted={};
						console.log(data);
						$scope.msg="";
					}).error(function(data) {
						console.log(data);
						$scope.msg = data.message;
					}); 
		  }
		
			
		}

});
///////////////////////////////////////////////////////////////////////////////
// commande entree commande entree
/////////////////////////////////////////////////////////////////////////////
app.controller('CommandeEntreeCtrl', function($window,$modal,$scope,getFournisseurs, $http,$routeParams) {
	// load select fournisseurs
		getFournisseurs.query(function(data) {
			$scope.fournisseurs = data;
		});
		$scope.msg ="";	
	var HostName = 'http://localhost:8681';
	$scope.onInsert = function() {
		var montant = parseInt($scope.inserted.montant);
		var dateCommande = moment($scope.inserted.dateCommande).format('YYYY-MM-DD');
		var params ="idCommande="+$scope.inserted.idCommande+
					"&montant="+montant+
					"&dateCommande="+dateCommande+
					"&idFournisseur="+$scope.inserted.fournisseur
		console.log(params);
		if(angular.isNumber(montant) || montant<0) {
			  $scope.msg="le montant doit etre un nombre et supperieur a zero";
		  }
		  /*if(angular.isDate($scope.inserted.dateCommande)){
			  $scope.msg="vous devez choisir le prix du vente";
		  }*/
		  if(angular.isUndefined($scope.inserted.fournisseur)){
			  $scope.msg="vous devez choisir un fournisseur";
		  }
		  console.log(parseInt($scope.inserted.montant));
		  if(angular.isNumber(montant) && montant >0 && !angular.isUndefined($scope.inserted.fournisseur)){
			  
			  $http({
					method : 'POST',
					url : HostName + '/commandeentree',
					data : params,
					headers : {
								'Content-Type' : 'application/x-www-form-urlencoded'
							}
					}).success(function(data) {
						$window.location.href= '#entrees/'+data.idCommande;
						$scope.formEntree.$submitted = false;

						console.log(data);
						$scope.msg="";
					}).error(function(data) {
						console.log(data);
						$scope.msg = data.message;
					}); 
		  }
		
			
		}

});
///////////////////////////////////////////////////////////////////////////////
//commande sortie commande sortie
/////////////////////////////////////////////////////////////////////////////
app.controller('CommandeSortieCtrl', function($window,$modal,$scope,getClients, $http,$routeParams) {
	// load select fournisseurs
		getClients.query(function(data) {
			$scope.clients = data;
		});
		$scope.msg ="";	
		$scope.inserted={};
	var HostName = 'http://localhost:8681';
	$scope.onInsert = function() {
		var params ="idCommande="+$scope.inserted.idCommande+
					"&idClient="+$scope.inserted.client
		console.log(params);
		$http({
			method : 'POST',
			url : HostName + '/commandesortie',
			data : params,
			headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
			}).success(function(data) {
				$window.location.href= '#sorties/'+data.idCommande;
				console.log(data);
			}).error(function(data) {
				console.log(data);
				$scope.msg = data.message;
			});
			
		}

});
var ModalInstanceEditCtrl = function($scope, $modalInstance, $modal, item,sortie) {
    
    $scope.item = sortie.data;
     $scope.ok = function () {
       $modalInstance.close();
     };
     $scope.cancel = function () {
       $modalInstance.dismiss('cancel');
     };
}
var ModalInstanceCtrl = function($scope, $modalInstance, $modal, item) {
    
    $scope.item = item;
     $scope.ok = function () {
       $modalInstance.close();
     };
     $scope.cancel = function () {
       $modalInstance.dismiss('cancel');
     };
}
// Directive for generic chart, pass in chart options
app.directive('hcChart', function () {
    return {
        restrict: 'E',
        template: '<div></div>',
        scope: {
            options: '='
        },
        link: function (scope, element) {
            Highcharts.chart(element[0], scope.options);
        }
    };
})
// Directive for pie charts, pass in title and data only    
app.directive('hcPieChart', function () {
    return {
        restrict: 'E',
        template: '<div></div>',
        scope: {
            title: '@',
            data: '='
        },
        link: function (scope, element) {
            Highcharts.chart(element[0], {
                chart: {
                    type: 'pie'
                },
                title: {
                    text: scope.title
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                        }
                    }
                },
                series: [{
                    data: scope.data
                }]
            });
        }
    };
})
app.controller('myController', function ($http,$scope,getNbrCommandeYear) {
	$scope.co=[];
		$scope.co=getNbrCommandeYear.query(function(data) {
			return $scope.commandes = data;
			//console.log($scope.commandes);
		})
		//console.log($scope.co);
		 for( var i in $scope.co) {
			console.log(JSON.parse(JSON.stringify($scope.co[i])));
			console.log("-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-")
		}
	
	
    // Sample options for first chart
    $scope.chartOptions = {
        title: {
            text: 'la temperature'
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },

        series: [{
            data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }]
    };

    // Sample data for pie chart
    $scope.pieData = [{
            name: "8",
            y: 8
        }, {
            name: "2",
            y: 8,
            sliced: true,
            selected: true
        }, {
            name: "3",
            y: 5
        }, {
            name: "4",
            y: 10
        }]
});
///////////////////////////////////////////////////////////////////////////////
//Etats Etats Etats Etats Etats
/////////////////////////////////////////////////////////////////////////////
app.controller('CodesCtrl', function($scope, $http, getCodes, $routeParams) {
	// init params for pagination
	$scope.pageCodes = {};
	$scope.pageSize = 10;
	$scope.pageCourante = 0;
	$scope.pages = {};
	// get paginate taxes
	$scope.chargerCodes = function() {
		$scope.errorMessage = null;
		$http.get(
				"/getCodes?page=" + $scope.pageCourante
						+ "&size=" + $scope.pageSize).success(
				function(data) {
					$scope.pageCodes = data;
					$scope.pages = new Array(data.totalPages)
				}).error(function(data) {
			$scope.errorMessage = data.message;
		});
	};
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerCodes();
	};
	$scope.getPdf = function() {
		$http.get(HostName+'/codes.pdf',{responseType:'arraybuffer'})
		.success(function(data) {
			var file = new Blob([data],{type:'application/pdf'});
			var fileURL =URL.createObjectURL(file);
			window.open(fileURL,'_blank','')
		})
	};
	
	//Retrive all Etats using "Etats" Service
	var HostName = 'http://localhost:8681';
	//Get
	$http({
		method : 'GET',
		url : HostName + '/codes',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data) {
		console.log("Loaded successfully!");
		$scope.chargerCodes();
		})
	.error(function(data) {
		$scope.codes = {};
		console.log(data);
		//$scope.msg =data;
		// $scope.msg = "Failed to laod please contact developer!";
	});
	//insert new record block
	$scope.inserted = {};
	//Call api insert Action
	$scope.onInsert = function() {
		$http({
			method : 'POST',
			url : HostName + '/codes',
			data : $.param($scope.inserted),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.chargerCodes();
		}).error(function(data) {
			console.log(data);
			$scope.msg = data;
		});
	}

	//remove selected record block
	$scope.onDelete = function(id) {
		if (confirm("etes vous sur ? ")) {
			$http({
				method : 'DELETE',
				url : HostName + '/codes/' + id,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				$scope.chargerCodes();
			}).error(function(data) {
				//console.log(data);
				//$scope.msg =data;
				$scope.msg = "Failed to remove please contact developer!";
			});
		}
	}
});
app.controller('navigationCtrl', function($rootScope, $scope,$http, $location, $route) {
	var self = $scope;
	var HostName = 'http://localhost:8681';

	$scope.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};
	$scope.credentials={}
	var authenticate = function(credentials, callback) {

		var headers = credentials ? {
			authorization : "Basic "
					+ btoa($scope.credentials.idUser + ":"
							+ $scope.credentials.password)
		} : {};
		$http.get(
				"/user?idUser=" + $scope.credentials.idUser
						+ "&password=" + $scope.credentials.password)
			.success(function(data) {
					console.log("youpi");
					$rootScope.authenticated = true;
				}).error(function(data) {
					$rootScope.authenticated = false;
					console.log(" no youpi");
		});
/*		$http.get('/user', {
			headers : headers
		}).then(function(response) {
			console.log(response);
			if (response.data.name) {
				$rootScope.authenticated = true;
				console.log("im here10");

			} else {
				$rootScope.authenticated = false;
				console.log("im here20");

			}
			callback && callback($rootScope.authenticated);
		}, function() {
			$rootScope.authenticated = false;
			callback && callback(false);
		});*/

	}

	authenticate();
	
	$scope.credentials = {};
	$scope.login = function() {
		console.log($scope.credentials)
		authenticate($scope.credentials, function(authenticated) {
			if (authenticated) {
				console.log("Login succeeded")
				$location.path("/users");
				self.error = false;
				$rootScope.authenticated = true;
			} else {
				console.log("Login failed")
				$location.path("/login");
				$scope.error = true;
				$rootScope.authenticated = false;
				
			}
		})
	};

	$scope.logout = function() {
		$http.post('logout', {}).finally(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		});
	}

});
app.controller('home', function($rootScope, $http, $location, $route) {

var self = this;
$http.get('/resource/').then(function(response) {
self.greeting = response.data;
})
});
