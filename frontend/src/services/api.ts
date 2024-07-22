import { response } from "express";

const ROOT = "https://localhost:8080/";

    //function to parse the returning information as json
    const parseJSON = (response: any) => {
        if(response.status === 204 || response.status === 205) {
            return null;
        }
        return response.json();
    }

    /*
        A function to check the status of the fetch.
        If the response is not 200, throw an error
    */
    const checkStatus = (response: any) => {
        if(response.status >= 200 && response.status < 300) {
            return response;
        }
        const error: any = new Error(response.statusText);
        error.response = response;
        throw error;
    }

    /*
        A Function to get information from DB

        @param String endpoint  A endpoint to call (ex: user)
        @param String[] options A array of options (MUST BE IN ORDER, ex: [id, 'users'])
        
        @return {object} The response Data
    */
    const get = (endpoint: String, options: String[]) => {
        let url = ROOT + endpoint;
        options.forEach(element => {
            url = url + "/" + element;
        });
        return fetch(url, {
            method: "GET"
        }).then(checkStatus).then(parseJSON);
    }
    
    /*
        A Function to post information to the DB

        @param String endpoint  A endpoint to call (ex: user)
        @param String[] options A array of options (MUST BE IN ORDER, ex: [id, 'users'])
        @param {object} optionsBody A object containing the values needed for the request body (ex: { username: "name" })

        @return {object} The response Data
    */
    const post = (endpoint: String, options: String[], optionsBody: any) => {
        let url = ROOT + endpoint;
        options.forEach(element => {
            url = url + "/" + element;
        })
        return fetch(url, {
            method: "POST",
            body: JSON.stringify(optionsBody)
        }).then(checkStatus).then(parseJSON);
    }

