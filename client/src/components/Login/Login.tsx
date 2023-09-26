import { useGoogleLogin } from "@react-oauth/google";
import axios from "axios";
import backgroundImage from "../../images/backgroundPetAdoption.jpg"; // Update the path to your image
import GoogleLogin from "../Buttons/GoogleLogin";
import "./css/Login.css";

function Login() {
  const login = useGoogleLogin({
    onSuccess: async (response) => {
      try {
        const res = await axios.get(
          "https://www.googleapis.com/oauth2/v3/userinfo",
          {
            headers: {
              Authorization: `Bearer ${response.access_token}`,
            },
          }
        );
        console.log(res.data);
        let body = {
          email: res.data.email,
          username: res.data.name,
          photoUrl: res.data.picture,
        };
        axios
          .post("http://localhost:8080/users/add", body)
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.log(err);
          });
      } catch (err) {
        console.log(err);
      }
    },
  });

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundImage})`,
        backgroundSize: "60% 100%",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center",
        opacity: "0.7",
        backgroundColor: "#e2cbe0",
      }}
      className="relative flex flex-col justify-center min-h-screen overflow-hidden"
    >
      <div className="justify-center text-pink-700 font-bold text-2xl text-center pt-12 mb-28">
        Welcome to Adoptinator
      </div>
      <div className="w-full p-6 m-auto bg-white rounded-md shadow-xl shadow-rose-600/40 ring ring-2 ring-pink-400 lg:max-w-xl mt-4">
        <h1 className="text-3xl font-bold text-center text-pink-700 uppercase">
          Sign in
        </h1>
        <div
          className="w-full"
          onClick={() => {
            login();
          }}
        >
          <GoogleLogin />
        </div>
        <p className="mt-4 text-xs font-light text-center text-gray-700">
          {" "}
          Don't have an account?{" "}
          <a href="#" className="font-medium text-purple-600 hover:underline">
            Sign up
          </a>
        </p>
      </div>
    </div>
  );
}

export default Login;
