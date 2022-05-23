
trait Monad[F[_]] {

  def pure[A](a: A): F[A]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = flatMap(fa)(res1 => flatMap(fb)(res2 => pure(f(res1, res2))))

  def sequence[A](fas: List[F[A]]): F[List[A]] = fas.foldLeft(pure(List.empty[A]))((el, fa) => flatMap(fa)((a: A) => flatMap(el)(b => pure(b :+ a))))

  def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = a => flatMap(f(a))(b => g(b))
}

trait Functor[F[_]] {
  def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
  def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
    def map[A, B](a: F[A])(f: A => B): F[B] = M.flatMap(a)(res=>M.pure(f(res)))
  }
}
