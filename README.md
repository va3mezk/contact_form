# Contact form

## Description/Descripción 📋

🇪🇸 

Para cualquier tipo de app, es muy importante que haya un formulario de contacto con el que poder comunicarse con los usuarios, y por ello el reto de hoy.

🇺🇸

For any type of application, it is very important that there is a contact form with which to communicate with users, and therefore today's challenge.

![image](https://user-images.githubusercontent.com/87434896/143981893-91396fe8-7696-4390-8038-c5129f6940c0.png)

## How did I get to this solution to the challenge? / ¿Como llegue a esta solución del reto? 🤷🏻

🇺🇸

An MVVM pattern and retrofit to get the list of countries from the RESTCountries API (https://restcountries.eu/) and a function which validates the phone and email fields. Organize your files with a clean architecture.

🇪🇸

Utilice un patrón MVVM y retrofit para obtener la lista de países de la API RESTCountries(https://restcountries.eu/) y una función la cual valida los campos de teléfono y correo electrónico. Organice los ficheros con una clean arquitecture.



## Task/Tareas 🎯

🇪🇸 ✅ Task 1 → Puedo ver el diseño propuesto por pantalla 

🇺🇸 ✅ Task 1 → I can see the proposed design on the screen

- [activity_main.xml](https://github.com/va3mezk/contact_form/blob/master/app/src/main/res/layout/activity_main.xml)  

- [spinner_item.xml](https://github.com/va3mezk/contact_form/blob/master/app/src/main/res/layout/spinner_item.xml)

![image](https://user-images.githubusercontent.com/87434896/144152796-542a3880-618e-4845-8e65-1fe9a77fc894.png)


🇪🇸 ✅ Task 2 → Los campos de teléfono y correo tiene manejo de errores y no permite enviar el formulario sin que sean correctos 

🇺🇸 ✅ Task 2 → The phone and mail fields have error handling and do not allow submitting the form without being correct

- [Validator.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/utils/Validator.kt)

- [MainActivity.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/presentation/MainActivity.kt)

         binding.vbAccept.setOnClickListener {
            if (!Validator.validText(1, binding.etEmail.text.toString()))
                binding.etEmail.error = getString(R.string.email_invalid)
            else if (!Validator.validText(2, binding.etPhone.text.toString()))
                binding.etPhone.error = getString(R.string.phone_invalid)
            else {
                val snackBar = Snackbar.make(
                    binding.clMain, getString(R.string.validField),
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)
                snackBar.show()
            }
        }

![image](https://user-images.githubusercontent.com/87434896/144152844-d06f0d14-7a2e-4f8a-84b0-52e8b2d2809b.png)
![image](https://user-images.githubusercontent.com/87434896/144152926-3bca8186-67c7-455d-8344-c3b53e9f6e55.png)
![image](https://user-images.githubusercontent.com/87434896/144152986-5c325995-d5dc-47bd-bbc8-98d9ba8112fa.png)


🇪🇸 ✅ Task 3 → Puedo ver como mínimo una lista de 10 países 

🇺🇸 ✅ Task 3 → I can see at least a list of 10 countries

🇪🇸 ✅ Task 4 → Puedo ver una lista de países completa integrando la API de países RESTCountries(https://restcountries.eu/) 

🇺🇸 ✅ Task 4 → I can see a complete list of countries by integrating the RESTCountries countries API (https://restcountries.eu/)

- [MainActivity.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/presentation/MainActivity.kt)
- [MainViewModelFactory.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/domain/MainViewModelFactory.kt)
- [MainViewModel.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/domain/MainViewModel.kt)
- [MainRepository.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/domain/MainRepository.kt)
- [ApiInterface.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/data/ApiInterface.kt)
- [CountryData.kt](https://github.com/va3mezk/contact_form/blob/master/app/src/main/java/net/vezk/contact_form/data/CountryData.kt)

![image](https://user-images.githubusercontent.com/87434896/144153004-5ca94784-44e3-4e69-a686-3ff68a1df0ee.png)

## Created by🧑🏻‍💻

- Victor Escalante

## Licence 📝

- https://opensource.org/licenses/MIT
